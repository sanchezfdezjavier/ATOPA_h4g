/**
 * 
 */
package es.upm.h4g.atopa;
import java.util.*;
/**
 * @author Daniel del Riego San Martín
 *
 */
public class Clase {
	private Map<Integer, Alumno> alumnosmap;
	private String nombre;//Rollo 1c y eso
	
	public Clase(List<Alumno> alumnos, String nombre){
		this.alumnosmap = new HashMap<>();
		for (Alumno a: alumnos){
			this.alumnosmap.put(a.getNumero(), a);
			this.nombre = nombre;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Alumno getAlumno(int n){
		return alumnosmap.get(n);
	}
	public List<Alumno> getAlumnos(){
		List<Alumno> alumnos = new ArrayList<>(alumnosmap.values());
		return alumnos;
	}
}
