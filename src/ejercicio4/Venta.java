package ejercicio4;

import java.util.Enumeration;
import java.util.Hashtable;

public class Venta {
	private final double IVA4 = 1.04, IVA21 = 1.21;

	private Hashtable<String, Double> listaProductos;
	private int iva;
	private double cantidadAbonada;

	public Venta(Hashtable<String, Double> listaProductos, double cantidadAbonada) {
		this.listaProductos = listaProductos;
		this.cantidadAbonada = cantidadAbonada;
	}

	public Venta(Hashtable<String, Double> listaProductos, int iva, double cantidadAbonada) {
		this.listaProductos = listaProductos;
		this.iva = iva;
		this.cantidadAbonada = cantidadAbonada;
	}

	/**
	 * Devuelve la cantidad de dinero abonada por el cliente
	 * 
	 * @return Dinero abonado por el cliente
	 */
	public double getCantidadAbonada() {
		return cantidadAbonada;
	}

	/**
	 * Retorna el importe total de los articulos adquiridos
	 * 
	 * @return Suma total con IVA
	 */
	public double getSumaTotalConIva() {
		Enumeration<Double> valores = listaProductos.elements();
		double sumaTotalConIva = 0.0;

		while (valores.hasMoreElements()) {
			sumaTotalConIva += valores.nextElement();
		}
		return sumaTotalConIva;
	}

	/**
	 * Devuelve la cantidad de artículos
	 * 
	 * @return Pues eso, la cantidad de artículos
	 */
	public int recuento() {
		return listaProductos.size();
	}

	/**
	 * Retorna el importe total de los articulos adquiridos descontando el IVA
	 * 
	 * @return Importe total sin IVA
	 */
	public double calculaSinIva() {
		Enumeration<Double> valores = listaProductos.elements();
		double sumaTotalConIva = 0.0;
		double sumaTotalSinIva = 0.0;

		while (valores.hasMoreElements()) {
			sumaTotalConIva += valores.nextElement();
		}

		if (iva == 4) {
			sumaTotalSinIva = sumaTotalConIva / IVA4;
		} else if (iva == 21) {
			sumaTotalSinIva = sumaTotalConIva / IVA21;
		} else {
			sumaTotalSinIva = sumaTotalConIva;
		}
		return sumaTotalSinIva;
	}

}
