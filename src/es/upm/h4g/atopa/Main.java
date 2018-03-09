package es.upm.h4g.atopa;
import java.util.*;
import java.io.*;
import java.net.*;

import java.io.IOException;

import java.net.URL;


public class Main {

	public static void main(String[] args) {
		String s = "1 2 5";
		List<Alumno> alumnos = new ArrayList<>();
		for(int i = 0; i<30; i++){
			alumnos.add(new Alumno("Pedro", "Perez", 15, "1B"));
		}
		
		Clase primeroB = new Clase(alumnos, "1B");
		List<String> soluciones= new ArrayList<String>();
		soluciones.add(s);
		Map <String, List<String>> valores = new HashMap <String, List<String>>();
		
		for(int i = 1; i<=5; i++){
			valores.put(Integer.toString(i), soluciones);
		}
		
		for(String t: valores.keySet()){
			System.out.println(t);
			System.out.println(valores.get(t));
		}
		
		File f = new File("/home/default/Downloads/Hoja.xls");
		System.out.println(f.canRead());
		
		
		Graph g1 = new Graph(valores, primeroB);
		
		ScreenSolitarios e1 = new ScreenSolitarios("Test", -50, 105, -50, 500, g1);
		
		
	}
	
	

}
