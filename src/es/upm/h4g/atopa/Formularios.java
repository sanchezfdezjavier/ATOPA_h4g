package es.upm.h4g.atopa;
import java.util.*;

/**
 * @author Nacho
 *En esta clase se almacenan todos los formualarios: en un map de la siguiente forma: nombre
 *de la clase a la que se le pasa el formulario, link. Se puede obtener el link a partir de 
 *la clase a la que pertenece el alumno. Se puede anadir un formulario a una clase
 */
public class Formularios {

	private Map <String, String> formularios;
	
	public Formularios(){
		formularios = new HashMap <String, String> ();
	}
	
	public void addFormulario(String clase, String url){
		formularios.put(clase, url);
	}
	
	public String getFormulario(String clase){
		String url = formularios.get(clase);
		if(url != null) return url;
		
		return "No tienes ninguna encuesta todavia. Habla con tu profe";
	}
	
	public Map <String, String> getFormularios(){
		return this.formularios;
	}
	
	
	
}
