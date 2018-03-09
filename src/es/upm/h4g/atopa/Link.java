package es.upm.h4g.atopa;

/**
 * @author Daniel del Riego San Martín
 *
 */

public class Link {
	private Node src, dst;
	private int weight;

	public Link(Node src, Node dst, int weight) {
		if (src == null || dst == null || weight < 0) {
			throw new IllegalArgumentException();
		} else {
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}
	}

	public Link(Node src, Node dst) {
		if (src == null || dst == null) {
			throw new IllegalArgumentException();
		} else {
			this.src = src;
			this.dst = dst;
		}
	}
	public Node getSrc() {
		return src;
	}

	public Node getDst() {
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
