/**
 * 
 */
package es.upm.h4g.atopa;

/**
 * @author Daniel del Riego San Martín
 *
 */
public class Alumno {
	private String nombre;
	private String apellidos;
	private int edad;
	private int numero;
	private static int ID = 1;
	private String clase;
	EstadoConflictivo estadoConflictivo;
	EstadoDivertido estadoDivertido;
	EstadoTrabajador estadoTrabajador;
public Alumno (String nombre, String apellidos, int edad, String clase){
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.edad = edad;
	this.numero = ID;
	ID++;
	this.clase = clase;
}


public EstadoConflictivo getEstadoConflictivo() {
	return estadoConflictivo;
}


public void setEstadoConflictivo(EstadoConflictivo estadoConflictivo) {
	this.estadoConflictivo = estadoConflictivo;
}


public EstadoDivertido getEstadoDivertido() {
	return estadoDivertido;
}


public void setEstadoDivertido(EstadoDivertido estadoDivertido) {
	this.estadoDivertido = estadoDivertido;
}


public EstadoTrabajador getEstadoTrabajador() {
	return estadoTrabajador;
}


public void setEstadoTrabajador(EstadoTrabajador estadoTrabajador) {
	this.estadoTrabajador = estadoTrabajador;
}


public String getClase() {
	return clase;
}
public void setClase(String clase) {
	this.clase = clase;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
@Override
public String toString() {
	return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", clase=" + clase + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
	result = prime * result + edad;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Alumno other = (Alumno) obj;
	if (apellidos == null) {
		if (other.apellidos != null)
			return false;
	} else if (!apellidos.equals(other.apellidos))
		return false;
	if (edad != other.edad)
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}



}