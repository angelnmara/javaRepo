package mx.gob.economia.miam.expediente.apiRest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;

import mx.gob.economia.miam.expediente.model.apiEntity;

public class ejecutaServicio {

	@PostConstruct	
	public void ejecutaGET(apiEntity ae) {
		try {			
			//URL url = new URL("http://192.168.104.172:7001/miam/gateway/expediente/consultaDocumento/15f51d65-07ca-400e-a330-6314ef06d8d0");
			URL url = new URL(ae.getUrlFinal());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

//			String input = ce.getVariableCamunda();
//
//			OutputStream os = conn.getOutputStream();
//			os.write(input.getBytes());
//			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				//ce.setErrorCamunda(conn.getResponseMessage());
				//ce.setErrorCamunaNumero(conn.getResponseCode());
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			StringBuilder salida = new StringBuilder();
			System.out.println("Output from Server .... \n");			
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				//String ltrim = output.replaceAll("^\\s+","");
				//String rtrim = output.replaceAll("\\s+$","");
				salida.append(output.replaceAll("^\\s+","").replaceAll("\\s+$",""));
				//ce.setRespuestaCamunda(output);
			}

			ae.setRespuesta(salida.toString());
			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }
	}
	
}
