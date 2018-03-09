package es.upm.h4g.atopa;

import java.util.*;
import java.math.*;
public class Graph {
	private double radio;
	private double alfa = 0;
	private Map<Integer, Node> nodesmap = new HashMap<>();
	private Map<Alumno, List<Link>> linksmap = new HashMap<>();
	private Map<String, List<String>> respuestas;

	public Graph(Map<String, List<String>> respuestas) {
		this.respuestas = respuestas;
		for (String s : respuestas.keySet()){
			List<Integer> numeros = transforma(s);
			for (int i = 1; i < numeros.size(); i++){
				double x = radio*Math.cos(alfa);
				double y = radio*Math.sin(alfa);
				Node n = new Node(getNode(i).getAlumno(), (int)x, (int)y);
				for(List<String> s2 : respuestas.values()){
					for (String s3 : s2){
						List<Integer> relaciones = transforma(s3);
						for (int m = 0; m<relaciones.size();m++){
							Link l = new Link(getNode(i).getAlumno(), getNode(m).getAlumno());
							addLink(l);
						}
					}
				}
				
			}
			
		
		}
	}
	
	public List<Integer> transforma(String s) {
		int anterior = -1;
		List <Integer> respuestas = new ArrayList<Integer>();
		
		for(int i = 0; i< s.length(); i++){
			if(s.charAt(i) == ' '){
				respuestas.add(Integer.parseInt(s.substring(anterior+1, i)));
				anterior = i;
			}
		}
		respuestas.add(Integer.parseInt(s.substring(anterior+1, s.length())));
		
		return respuestas;

	}

	public List<Node> getNodes() {
		ArrayList<Node> alumnos = new ArrayList<>(nodesmap.values());
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

	public void addNode(Node node) {
		nodesmap.put(node.getAlumno().getNumero(), node);
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

	public Node getNode(int numero) {
		return nodesmap.get(numero);
	}

	public Link getLink(Node src, Node dst) {
		List<Link> linkList = this.linksmap.get(src);
		for(Link link : linkList){
			if (link.getSrc().equals(src)&& link.getDst().getNombre().equals(dst)){
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

	public int getWeight(List<Node> path) {
		int sum = 0;
		for (int i = 1; i < path.size(); i++) {
			Node previous = path.get(i - 1);
			Node current = path.get(i);
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
