package gui;
import java.sql.*;

public class jdbc {

	Connection myConn=null;
	public static Connection dbConnector() {

		try {
			// Verbindung Datenbank
			Connection myConn = DriverManager.getConnection("jdbc:mysql://remotemysql.com/X7MoXa8AEB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" , "X7MoXa8AEB" , "loK6LV68qp");
			return myConn;
			/*
			//Statement erschaffen
			Statement myTest = myConn.createStatement();
			
			//SQL QUERY
			ResultSet myRs = myTest.executeQuery("Select * from Tisch");
			//SQL QUERY Ausgabe
			while (myRs.next()) {
				System.out.println("Nummer:" + myRs.getInt("Nummer") + "," + "Fensterplatz:" + myRs.getBoolean("Fensterplatz") + "," + "St�hle:" + myRs.getInt("St�hle") );
			}
		*/
		
		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		}

	}

}
