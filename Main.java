package es.upm.h4g.atopa;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		String s = "1 2 5";
		List<Alumno> alumnos = new ArrayList<>();
		for(int i = 0; i<5; i++){
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
		
		Graph g1 = new Graph(valores, primeroB);
		
		ScreenSolitarios e1 = new ScreenSolitarios("Test", -50, 150, -50, 150, g1);
		
		
	}
	
	

}
