package es.upm.h4g.atopa;



public class Clase {
    private Map<Integer, Alumno> alumnos;
    private String nombre;//Rollo 1c y eso

    public Clase(List<Alumno> alumnos, String nombre){
        this.alumnos = new HashMap<😠);
        for (Alumno a: alumnos){
            this.alumnos.put(a.getNumero(), a);
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
        return alumnos.get(n);
    }

}