package mx.gob.economia.miam.expediente.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.lamarrulla.dbAcces.*;

@Path("GestorExpediente")
@Consumes("application/json")
@Produces("application/json")
public class GestorExpediente {
	public GestorExpediente() {
		super();
	}	
	
	@GET	
	public String recuperaTramitePorNodo(@Context HttpHeaders headers) throws Exception {

		String salida =  headers.getHeaderString("hola");
		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		if(nodo == null) {
//			salida = ae.getRespuesta();
//		}else {
//			JsonNode rootNode = mapper.readValue(ae.getRespuesta(), JsonNode.class);
//			salida = rootNode.findValue(nodo).toString();
//		}
		
		//JsonNode rootNode = mapper.readValue(ae.getRespuesta(), JsonNode.class);
		
		//salida = ((nodo == null) ? ae.getRespuesta() : rootNode.findValue(nodo).toString());
		

		EjecutaConsulta ec = new EjecutaConsulta();
		//ec.selectDB("");
		
		System.out.println(salida);
				
		return "{\"hola\":\"" + salida + "\"}";
	} 
}