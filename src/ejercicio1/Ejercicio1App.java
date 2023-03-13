package ejercicio1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio1App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nombreAlumno;
		Hashtable<String, Double> listaAlumnos = new Hashtable<String, Double>();
		ArrayList<Double> notasAlumno = new ArrayList<Double>();
		
		System.out.println("Introduce nombre alumno/a:");
		nombreAlumno = scan.nextLine();
		
		System.out.println("Introduce notas del alumno/a: (Escribe -1 para finalizar)");
		double nota = scan.nextDouble();
		
		while(nota != -1) {
			notasAlumno.add(nota);
			nota = scan.nextDouble();
		}
		
		double sumaNotas = 0;
		
		for(int i = 0; i < notasAlumno.size(); i++) {
			System.out.println(notasAlumno.get(i));
			sumaNotas += notasAlumno.get(i);
		}
		
		double notaMedia = sumaNotas / notasAlumno.size();
		System.out.println("MEDIA: "+notaMedia);
		
		listaAlumnos.put(nombreAlumno, notaMedia);
		
		System.out.println("Quieres añadir otro alumno/a? \n 1 --> SI 2 --> NO");
		int respuesta = scan.nextInt();
		
		while (respuesta == 1) {
			scan.nextLine();
			
			System.out.println("Introduce nombre alumno/a:");
			nombreAlumno = scan.nextLine();
			
			System.out.println("Introduce notas del alumno/a: (Escribe -1 para finalizar)");
			nota = scan.nextDouble();
			
			while(nota != -1) {
				notasAlumno.add(nota);
				nota = scan.nextDouble();
			}
			
			sumaNotas = 0;
			
			for(int i = 0; i < notasAlumno.size(); i++) {
				System.out.println(notasAlumno.get(i));
				sumaNotas += notasAlumno.get(i);
			}
			
			notaMedia = sumaNotas / notasAlumno.size();
			System.out.println("MEDIA: "+notaMedia);
			
			listaAlumnos.put(nombreAlumno, notaMedia);
			
			System.out.println("Quieres añadir otro alumno/a? \n 1 --> SI 2 --> NO");
			respuesta = scan.nextInt();
		}
		
		Enumeration<String> claves = listaAlumnos.keys();
		Enumeration<Double> valores = listaAlumnos.elements();
		
		while(claves.hasMoreElements()) {
			System.out.println("Nombre alumno "+claves.nextElement()
					+ " Nota media "+valores.nextElement());
		}
		
		scan.close();
	}

}
