package es.upm.h4g.atopa;

import java.util.*;
public class Graph {
	private Map<Integer, Alumno> alumnosmap = new HashMap<>();
	private Map<Alumno, List<Link>> linksmap = new HashMap<>();
	private Map<String, List<String>> respuestas;

	public Graph(Map<String, List<String>> respuestas) {
		this.respuestas = respuestas;
		for (int i = 1; i < respuestas.size();i++){
			String.
		}
	}

	public List<Alumno> getAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>(alumnosmap.values());
		return alumnos; 
	}

	public List<Link> getLinks() {
		ArrayList<List<Link>> links = new ArrayList<>(linksmap.values());
		ArrayList<Link> linksdevueltos = new ArrayList<>();
		for(List<Link> link : links){
			for (Link link1 : link){
				if(link1 == null){
					continue;
				}
				else linksdevueltos.add(link1);
			}
			
		}
			
		return linksdevueltos;
	}

	public void addNode(Alumno node) {
		alumnosmap.put(node.getNumero(), node);
	}

	public void addLink(Link link) {
		Alumno src = getAlumno(link.getSrc().getNumero());
		if (src != null){
			List<Link> links = getLinks(src);
			if (links.size() <= 0){
				links = new ArrayList<>();
				this.linksmap.put(src, links);
				links.add(link);
			}
			else{
				links.add(link);
			}
		}
	}

	public void addLink2D(Alumno a, Alumno b, int w) {
		Link link1 = new Link(a, b, w);
		Link link2 = new Link(b, a, w);
		this.addLink(link1);
		this.addLink(link2);
	}

	public Alumno getAlumno(int numero) {
		return alumnosmap.get(numero);
	}

	public Link getLink(Alumno src, Alumno dst) {
		List<Link> linkList = this.linksmap.get(src);
		for(Link link : linkList){
			if (link.getSrc().getNombre().equals(src.getNombre())&& link.getDst().getNombre().equals(dst.getNombre())){
				return link;
			}
		}
		return null;
	}

	public List<Link> getLinks(Alumno alumno) {
		List<Link> alumnolinks = linksmap.get(alumno);
		if (alumnolinks != null){
			return alumnolinks;
		}
		else{
			alumnolinks = new ArrayList<>();
		}
		return alumnolinks;
	}

	public int getWeight(List<Alumno> path) {
		int sum = 0;
		for (int i = 1; i < path.size(); i++) {
			Alumno previous = path.get(i - 1);
			Alumno current = path.get(i);
			Link link = this.getLink(previous, current);
			if (link == null) {
				return -1;
			} else {
				sum += link.getWeight();
			}
		}
		return sum;
	}
}
