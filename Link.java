/**
 * 
 */
package es.upm.h4g.atopa;

/**
 * @author Daniel del Riego San Martín
 *
 */

public class Link {
	private Alumno src, dst;
	private int weight;

	public Link(Alumno src, Alumno dst, int weight) {
		if (src == null || dst == null || weight < 0) {
			throw new IllegalArgumentException();
		} else {
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}
	}

	public Link(Alumno src, Alumno dst) {
		if (src == null || dst == null) {
			throw new IllegalArgumentException();
		} else {
			this.src = src;
			this.dst = dst;
		}
	}
	public Alumno getSrc() {
		return src;
	}

	public Alumno getDst() {
		return dst;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Link [src=" + src + ", dst=" + dst + "]";
	}

}

