package mx.gob.economia.miam.expediente.dbAcces;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EjecutaConsulta {
	public static void main(String[] argv) throws SQLException {

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
			System.out.println("You made it, take control your database now!");			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from tbcatcampo;");
			while(rs.next()) {
				System.out.print("columna uno regresada ");
				System.out.println(rs.getString(2));
			}
			rs.close();
			st.close();
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
