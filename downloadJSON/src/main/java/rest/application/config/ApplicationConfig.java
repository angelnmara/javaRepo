package rest.application.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("recursosweb")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return getRestClasses();
	}

	// Auto-generated from RESTful web service wizard
	private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();		
		resources.add(mx.gob.economia.miam.expediente.ws.GestorExpediente.class);
		return resources;
	}
}

// mx.gob.economia.miam.foliadora.WS.foliadoraWS.class