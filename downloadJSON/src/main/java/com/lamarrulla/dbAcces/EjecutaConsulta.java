package com.lamarrulla.dbAcces;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

public class EjecutaConsulta {
	
	private static JSONObject jsonObject;

	public static JSONObject getJsonObject() {
		return jsonObject;
	}

	public static void setJsonObject(JSONObject jsonObject) {
		EjecutaConsulta.jsonObject = jsonObject;
	}
	
	private static String consulta;

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		EjecutaConsulta.consulta = consulta;
	}

	public static void main(String[] argv) throws SQLException, JSONException {		
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/lamarrulladb", "postgres",
					"maradr");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");			
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			try {
				String stJS="";
				System.out.println("You made it, take control your database now!");			
				Statement st = connection.createStatement();
				//ResultSet rs = st.executeQuery("select fnAPI('tbcatobj');");
				//ResultSet rs = st.executeQuery("select * from fntablaamortcs(20000, 10, 24);");
				ResultSet rs = st.executeQuery(consulta);
				while(rs.next()) {
					System.out.print("columna uno regresada ");				
					stJS+=rs.getString(1);				
				}
				System.out.println(stJS);
				jsonObject = new JSONObject(stJS);					
				rs.close();
				st.close();
			}catch(Exception ex) {
				System.out.println("ocurrio un error: " +ex.getMessage());
			}			
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
