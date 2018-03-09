/**
 * 
 */
package es.upm.h4g.atopa;

/**
 * @author Daniel del Riego San Martín
 *
 */
public class Node {
	private Alumno alumno;
	private int x, y;
	EstadoConflictivo estadoConflictivo;
	EstadoDivertido estadoDivertido;
	EstadoTrabajador estadoTrabajador;
	
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

	public Node(Alumno alumno, int x, int y) {
		if (alumno == null) {
			throw new IllegalArgumentException();
		}
		this.alumno = alumno;
		this.x = x;
		this.y = y;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Node [alumno=" + alumno + ", x=" + x + ", y=" + y + "]";
	}
}

	
