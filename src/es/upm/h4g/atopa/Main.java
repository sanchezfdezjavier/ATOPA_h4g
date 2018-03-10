package es.upm.h4g.atopa;
import java.util.*;
import java.io.*;
import java.net.*;

import java.io.IOException;

import java.net.URL;


public class Main {

	public static void main(String[] args) {
		Data d = new Data();
		
		String ss1 = "1 2 5";
		String ss2 = "1 2 5";
		String ss3 = "1 2 5";
		String sc1 = "2 3 5";
		String sd1 = "3 4 1";
		String st1 = "4 3 3";
		String ss4 = "1 2 5";
		String ss5 = "1 2 5";
		String ss6 = "1 3 7";
		String sc2 = "2 3 5";
		String sd2 = "3 4 1";
		String st2 = "1 2 3";
		String ss7 = "1 2 5";
		String ss8 = "1 2 5";
		String ss9 = "1 2 5";
		String sc3 = "2 3 5";
		String sd3 = "2 7 1";
		String st3 = "1 2 3";
		String ss10 = "7 6 5";
		String sc4 = "1 2 5";
		String sd4 = "1 2 5";
		String st4 = "2 3 5";
		String sd5 = "3 4 1";
		String st5 = "1 2 3";
		String sc5 = "2 3 5";
		String sd6 = "9 3 4";
		String st6 = "2 4 9";
		String sc6 = "9 8 7";
		String sd7 = "6 7 8";
		String st7 = "3 4 5";
		String sc7 = "1 2 6";
		String sd8 = "1 2 5";
		String st8 = "2 3 5";
		String sc8 = "2 6 7";
		String sd9 = "1 3 8";
		String st9 = "9 5 4";
		String sc9 = "8 6 9";
		String sd10 = "5 6 7";
		String st10 = "5 6 7";
		String sc10 = "8 9 10";
		List<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno("Daniel"," ",10, "1B"));
		alumnos.add(new Alumno("Pablo"," ",12, "1B"));
		alumnos.add(new Alumno("Ignacio"," ",11, "1B"));
		alumnos.add(new Alumno("Javier"," ",10, "1B"));
		alumnos.add(new Alumno("María"," ",10, "1B"));
		alumnos.add(new Alumno("Laura"," ",11, "1B"));
		alumnos.add(new Alumno("Lorena"," ",10, "1B"));
		alumnos.add(new Alumno("Roberto"," ",10, "1B"));
		alumnos.add(new Alumno("Macarena"," ",10, "1B"));
		alumnos.add(new Alumno("Alfonso"," ",10, "1B"));
		
		Clase primeroB = new Clase(alumnos, "1B");
		
		List<String> soluciones1= new ArrayList<String>();
		soluciones1.add(ss1);
		soluciones1.add(sc1);
		soluciones1.add(st1);
		soluciones1.add(sd1);

	
		
		List<String> soluciones2 = new ArrayList<>();
		soluciones1.add(ss2);
		soluciones1.add(sc2);
		soluciones1.add(st2);
		soluciones1.add(sd2);
		List<String> soluciones3 = new ArrayList<>();
		soluciones1.add(ss3);
		soluciones1.add(sc3);
		soluciones1.add(st3);
		soluciones1.add(sd3);
		List<String> soluciones4 = new ArrayList<>();
		soluciones1.add(ss4);
		soluciones1.add(sc4);
		soluciones1.add(st4);
		soluciones1.add(sd4);
		List<String> soluciones5 = new ArrayList<>();
		soluciones1.add(ss5);
		soluciones1.add(sc5);
		soluciones1.add(st5);
		soluciones1.add(sd5);
		List<String> soluciones6 = new ArrayList<>();
		soluciones1.add(ss6);
		soluciones1.add(sc6);
		soluciones1.add(st6);
		soluciones1.add(sd6);
		List<String> soluciones7 = new ArrayList<>();
		soluciones1.add(ss7);
		soluciones1.add(sc7);
		soluciones1.add(st7);
		soluciones1.add(sd7);
		List<String> soluciones8 = new ArrayList<>();
		soluciones1.add(ss8);
		soluciones1.add(sc8);
		soluciones1.add(st8);
		soluciones1.add(sd8);
		List<String> soluciones9 = new ArrayList<>();
		soluciones1.add(ss9);
		soluciones1.add(sc9);
		soluciones1.add(st9);
		soluciones1.add(sd9);
		List<String> soluciones10 = new ArrayList<>();
		soluciones1.add(ss10);
		soluciones1.add(sc10);
		soluciones1.add(st10);
		soluciones1.add(sd10);
		Map <String, List<String>> valores = new HashMap<>();
		//Map <String, List<String>> valores = d.testHashMap();
		
		
		valores.put("1", soluciones1);
		valores.put("2", soluciones2);
		valores.put("3", soluciones3);
		valores.put("4", soluciones4);
		valores.put("5", soluciones5);
		valores.put("6", soluciones6);
		valores.put("7", soluciones7);
		valores.put("8", soluciones8);
		valores.put("9", soluciones9);
		valores.put("10", soluciones10);
		
		for(String t: valores.keySet()){
			System.out.println(t);
			System.out.println(valores.get(t));
		}
/*		
		File f = new File("/home/default/Downloads/Hoja.xls");
		System.out.println(f.canRead());*/
		
		
		
		Graph g1 = new Graph(valores, primeroB);
		
		ScreenSolitarios e1 = new ScreenSolitarios("Alumnos Solitarios", -50, 105, -50, 500, g1);
		ScreenConflictivos e2 = new ScreenConflictivos("Alumnos Conflictivos", -50, 105, -50, 500, g1);
		ScreenDivertidos e3 = new ScreenDivertidos("Alumnos Trabajadores", -50, 105, -50, 500, g1);
		ScreenTrabajador e4 = new ScreenTrabajador("Alumnos Divertidos", -50, 105, -50, 500, g1);
		
		
	}
	
	

}