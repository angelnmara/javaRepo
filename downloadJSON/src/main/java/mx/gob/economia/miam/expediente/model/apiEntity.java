package mx.gob.economia.miam.expediente.model;

public class apiEntity {
	
	private final String server = "http://192.168.104.172:7001";
	private final String gatewayr = "/miam/gateway/";
	private String servicio;
	private String urlFinal;
	private String respuesta;
	
//	public String getServicio() {
//		return servicio;
//	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	public String getUrlFinal() {
		return server + gatewayr + servicio;
	}
	
//	public void setUrlFinal(String urlFinal) {
//		this.urlFinal = urlFinal;
//	}
	
}
