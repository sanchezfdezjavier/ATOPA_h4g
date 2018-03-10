package es.upm.h4g.atopa;
import java.util.*;
import java.io.*;
import java.net.*;

import java.io.IOException;

import java.net.URL;


public class Main {

	public static void main(String[] args) {
		Data d = new Data();
		
		String ss = "1 2 5";
		String sc = "2 3 5";
		String sd = "3 4 1";
		String st = "1 2 3";
		List<Alumno> alumnos = new ArrayList<>();
		for(int i = 0; i<10; i++){
			alumnos.add(new Alumno("Pedro", "Perez", 10, "1B"));
		}
		
		Clase primeroB = new Clase(alumnos, "1B");
		List<String> soluciones= new ArrayList<String>();
		soluciones.add(ss);
		soluciones.add(sc);
		soluciones.add(st);
		soluciones.add(sd);

		Map <String, List<String>> valores = new HashMap<>();
		//Map <String, List<String>> valores = d.testHashMap();
		
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
		
		ScreenSolitarios e1 = new ScreenSolitarios("Alumnos Solitarios", -50, 105, -50, 500, g1);
		ScreenConflictivos e2 = new ScreenConflictivos("Alumnos Conflictivos", -50, 105, -50, 500, g1);
		ScreenDivertidos e3 = new ScreenDivertidos("Alumnos Trabajadores", -50, 105, -50, 500, g1);
		ScreenTrabajador e4 = new ScreenTrabajador("Alumnos Divertidos", -50, 105, -50, 500, g1);
		
		
	}
	
	

}
