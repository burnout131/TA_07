package ejercicio2;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio2App {
	final static double IVA4 = 1.04, IVA21 = 1.21;
	public static Hashtable<String, Double> listaProductos = new Hashtable<String, Double>();
	public static double cantidadAbonada;
	
	public static void calculaSinIva(double iva) {
		Enumeration<Double> valores = listaProductos.elements();
		double sumaTotalConIva = 0.0;
		double sumaTotalSinIva = 0.0;
		
		while (valores.hasMoreElements()) {
			sumaTotalConIva += valores.nextElement();
		}
		
		if(iva == 4.0) {
			sumaTotalSinIva = sumaTotalConIva / IVA4;
		}else if(iva == 21) {
			sumaTotalSinIva = sumaTotalConIva / IVA21;
		}else {
			sumaTotalSinIva = sumaTotalConIva;
		}
		
		System.out.println("CANTIDAD ARTICULOS: "+listaProductos.size());
		System.out.println("TOTAL CON IVA: "+ sumaTotalConIva);
		System.out.println("TOTAL SIN IVA: "+ sumaTotalSinIva);
		System.out.println("CANTIDAD PAGADA: " + cantidadAbonada);
		System.out.println("CAMBIO A DEVOLVER: " + (cantidadAbonada - sumaTotalConIva));
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nombreProducto;
		double importeProducto;
		int iva;
		
		System.out.println("Introduce Nombre producto (escribe 'fin' para terminar");
		nombreProducto = scan.nextLine().toLowerCase();
		System.out.println("Introduce el importe (con IVA incluido)");
		importeProducto = scan.nextDouble();
		
		listaProductos.put(nombreProducto, importeProducto);
		
		while (!nombreProducto.equals("fin")) {
			scan.nextLine();
			System.out.println("Introduce Nombre producto (escribe 'fin' para terminar");
			nombreProducto = scan.nextLine().toLowerCase();
			
			if(nombreProducto.equals("fin")) {
				break;
			}
			
			System.out.println("Introduce el importe (con IVA incluido)");
			importeProducto = scan.nextDouble();
			
			listaProductos.put(nombreProducto, importeProducto);
		}
		
		System.out.println("Introduce cantidad abonada por el cliente");
		cantidadAbonada = scan.nextDouble();
		System.out.println("Introduce porcentaje IVA (4 o 21)");
		iva = scan.nextInt();
		
		switch (iva) {
		case 21:
			calculaSinIva(21.0);
			break;
		case 4:
			calculaSinIva(4.0);
			break;
		default:
			System.out.println("No has introducido iva o no es una opcion valida. No se mostrará precio sin IVA");
			calculaSinIva(0.0);
			break;
		}
		
		scan.close();
	}

}
