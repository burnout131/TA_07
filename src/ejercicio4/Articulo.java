package ejercicio4;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Articulo {

	/**
	 * Este método nos permite añadir un Hashtable dentro de otro
	 * @param precio
	 * @param cantidad
	 * @return Hashtable con precios y cantidades de productos
	 */
	private Hashtable<Double, Integer> precioCantidad(double precio, int cantidad) {
		Hashtable<Double, Integer> preciosyCantidades = new Hashtable<Double, Integer>();
		preciosyCantidades.put(precio, cantidad);
		return preciosyCantidades;
	}

	/**
	 * Método que nos permite añadir articulos al stock o consultar lo que hay,
	 * dependiendo de la opción seleccionada
	 * @param scan
	 */
	public void gestionaStock(Scanner scan) {
		String opcion;
		String nombreArticulo;
		double precio;
		int cantidad;

		Hashtable<String, Hashtable<Double, Integer>> articulos = new Hashtable<String, Hashtable<Double, Integer>>();

		articulos.put("Galletas", precioCantidad(4.0, 5));
		articulos.put("Ron", precioCantidad(15.0, 3));
		articulos.put("Agua", precioCantidad(1.0, 2));
		articulos.put("Coca-cola", precioCantidad(1.90, 10));

		System.out.println("Elige el tipo de operación a realizar");
		System.out.println("Teclea AÑADIR para añadir artículo a la BD o CONSULTAR para ver el stock");
		System.out.println("Teclea SALIR para finalizar programa");
		
		scan.nextLine();
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
				System.out.println("Mostrando stock actualizado: ");
				
				Set<Entry<String, Hashtable<Double, Integer>>> entrySet1 = articulos.entrySet();

				for (Entry<String, Hashtable<Double, Integer>> entry : entrySet1) {
					System.out.println("Nombre articulo " + entry.getKey() + " Precio " + entry.getValue());
				}
				
				scan.nextLine();
				break;
			case "CONSULTAR":
				//scan.nextLine();
				System.out.println("Elige un numero como opción");
				System.out.println("1- Consultar todo || 2- Consultar por nombre");
				int opcionNum = scan.nextInt();
				if (opcionNum == 1) {
					Set<Entry<String, Hashtable<Double, Integer>>> entrySet2 = articulos.entrySet();

					for (Entry<String, Hashtable<Double, Integer>> entry : entrySet2) {
						System.out.println("Nombre articulo " + entry.getKey() + " Precio " + entry.getValue());
					}
				} else if (opcionNum == 2) {
					scan.nextLine();
					System.out.println("Introduce nombre articulo");
					String buscaPorNombre = scan.nextLine();
					System.out.println("{PRECIO=UNIDAD}");
					System.out.println(articulos.get(buscaPorNombre));
				}
			default:
				break;
			}
		}
	}
}
