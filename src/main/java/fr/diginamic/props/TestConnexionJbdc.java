package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestConnexionJbdc {

	public static void main(String[] args) {
		
		ResourceBundle config= ResourceBundle.getBundle("database");
		
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			Statement monStatement= connection.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
