import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

public class PrincipalCuento {

	private static void mostrarMenu() {
		System.out.println("SELECCIONE OPCION Y PULSE INTRO");
		System.out.println("1.- ESPAÑOL");
		System.out.println("2.- INGLÉS");
		System.out.println("3.- ITALIANO");
	}
	
	private static int leerOpcion() {
		int num_leido = 0;
		Scanner scanner = null;

			scanner = new Scanner(System.in);
			num_leido = scanner.nextInt();

		return num_leido;
	}

	private static void escribirCuento(String nombre_fichero) {
		Properties properties = null;
		FileReader fr = null;
		String inicio = null;
		String cuerpo = null;
		String fin = null;
		
			try {
				
				fr = new FileReader(nombre_fichero);
				properties = new Properties();
				properties.load(fr);
				inicio = properties.getProperty("start");
				cuerpo = properties.getProperty("body");
				fin = properties.getProperty("end");
				
				System.out.println(inicio);
				System.out.println(cuerpo);
				System.out.println(fin);
				
	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

	}
	
	private static String traducirOpcion (int op_selected)
	{
		String nombre_fichero = null;
		
			switch (op_selected) {
			case 1: //eligió español
				nombre_fichero = "story_es.properties";
				break;
			case 2://eligió inglés
				nombre_fichero = "story_en.properties";
				break;	
			case 3://eligió italiano
				nombre_fichero = "story_it.properties";
				break;
			}
			
		return nombre_fichero;
	}
	
	public static void main(String[] args) {
		String nombre_fichero = null;
		int n_leido = 0;
			
			mostrarMenu();
			n_leido = leerOpcion();
			nombre_fichero = traducirOpcion (n_leido);
			escribirCuento(nombre_fichero);

	}

}
