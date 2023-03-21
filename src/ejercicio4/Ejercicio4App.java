package ejercicio4;

import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio4App {
	public static Hashtable<String, Double> listaProductos = new Hashtable<String, Double>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		
		while (opcion != 3) {
			System.out.println("Bienvenido al programa de gestion de venta y stock de Mercadona:");
			System.out.println("Que deseas hacer?");
			System.out.println("1-Venta 2-Control de stock 3-Salir");

			opcion = scan.nextInt();
			if (opcion == 1) {
				String nombreProducto;
				double importeProducto;
				int iva;

				scan.nextLine();
				System.out.println("Introduce Nombre producto (escribe 'fin' para terminar");
				nombreProducto = scan.nextLine().toLowerCase();
				System.out.println("Introduce el importe (con IVA incluido)");
				importeProducto = scan.nextDouble();

				listaProductos.put(nombreProducto, importeProducto);

				while (!nombreProducto.equals("fin")) {
					scan.nextLine();
					System.out.println("Introduce Nombre producto (escribe 'fin' para terminar");
					nombreProducto = scan.nextLine().toLowerCase();

					if (nombreProducto.equals("fin")) {
						break;
					}

					System.out.println("Introduce el importe (con IVA incluido)");
					importeProducto = scan.nextDouble();

					listaProductos.put(nombreProducto, importeProducto);
				}
				
				System.out.println("Introduce cantidad abonada por el cliente");
				double cantidadAbonada = scan.nextDouble();
				System.out.println("Introduce porcentaje IVA (4 o 21)");
				iva = scan.nextInt();
				
				if(iva == 4 || iva == 21) {
					Venta venta = new Venta(listaProductos, iva, cantidadAbonada);
					System.out.println("CANTIDAD ARTICULOS: "+venta.recuento());
					System.out.println("TOTAL CON IVA: "+ venta.getSumaTotalConIva());
					System.out.println("TOTAL SIN IVA: "+ venta.calculaSinIva());
					System.out.println("CANTIDAD PAGADA: " + venta.getCantidadAbonada());
					System.out.println("CAMBIO A DEVOLVER: " + (venta.getCantidadAbonada() - venta.getSumaTotalConIva()));
				} else {
					System.out.println("No has introducido una opcion válida. No se mostrará precio sin IVA");
					Venta venta = new Venta(listaProductos, cantidadAbonada);
					System.out.println("CANTIDAD ARTICULOS: "+venta.recuento());
					System.out.println("TOTAL: "+ venta.getSumaTotalConIva());
					System.out.println("CANTIDAD PAGADA: " + venta.getCantidadAbonada());
					System.out.println("CAMBIO A DEVOLVER: " + (venta.getCantidadAbonada() - venta.getSumaTotalConIva()));
				}
			}
			
			if(opcion == 2) {
				
			}
		}
		
		scan.close();
	}

}
