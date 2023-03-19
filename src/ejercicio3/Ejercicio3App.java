package ejercicio3;

import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio3App {

	public static Hashtable<Double, Integer> precioCantidad(double precio, int cantidad) {
		Hashtable<Double, Integer> preciosyCantidades = new Hashtable<Double, Integer>();
		preciosyCantidades.put(precio, cantidad);
		return preciosyCantidades;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String opcion;
		String nombreArticulo;
		double precio;
		int cantidad;

		Hashtable<String, Hashtable<Double, Integer>> articulos = new Hashtable<String, Hashtable<Double, Integer>>();

		articulos.put("Galletas", precioCantidad(4.0, 5));
		articulos.put("Ron", precioCantidad(15.0, 3));
		articulos.put("Agua", precioCantidad(1.0, 2));
		articulos.put("Coca-cola", precioCantidad(1.90, 10));

		System.out.println("MERCADONA SUPERMERCADOS DE CONFIANZA (A RATOS)");
		System.out.println("Elige el tipo de operación a realizar");
		System.out.println("Teclea AÑADIR para añadir artículo a la BD o CONSULTAR para ver el stock");
		System.out.println("Teclea SALIR para finalizar programa");

		opcion = scan.nextLine().toUpperCase();

		while (!opcion.equals("SALIR")) {
			switch (opcion) {
			case "AÑADIR":
				System.out.println("Introduce nombre articulo:");
				nombreArticulo = scan.nextLine();
				System.out.println("Introduce precio articulo:");
				precio = scan.nextDouble();
				System.out.println("Introduce cantidad articulo:");
				cantidad = scan.nextInt();
				articulos.put(nombreArticulo, precioCantidad(precio, cantidad));
				System.out.println(articulos.get(nombreArticulo));
				System.out.println("Articulo añadido correctamente");
				scan.nextLine();
				break;
			case "CONSULTAR":
				//scan.nextLine();
				System.out.println("Elige un numero como opción");
				System.out.println("1- Consultar todo || 2- Consultar por nombre");
				int opcionNum = scan.nextInt();
				if (opcionNum == 1) {
					Set<Entry<String, Hashtable<Double, Integer>>> entrySet = articulos.entrySet();
					
					for(Entry<String, Hashtable<Double, Integer>> entry : entrySet) {
						System.out.println("Nombre articulo"+entry.getKey()+"Precio "+entry.getValue());
					}
				} else if(opcionNum == 2) {
					scan.nextLine();
					System.out.println("Introduce nombre articulo");
					String buscaPorNombre = scan.nextLine();
					System.out.println(articulos.get(buscaPorNombre));
				}
			default:
				break;
			}
		}
		
		scan.close();
	}

}
