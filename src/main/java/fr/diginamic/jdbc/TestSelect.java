package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
ResourceBundle config= ResourceBundle.getBundle("database");
		
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			Statement monStatement= connection.createStatement();
			ResultSet curseur = monStatement.executeQuery("SELECT id, nom FROM fournisseur");
			ArrayList<Fournisseur>fournisseurs= new ArrayList<>();
			
			while
				(curseur.next()) {
				int id= curseur.getInt("ID");
				String nom= curseur.getString("NOM");
				Fournisseur fournisseur= new Fournisseur(nom,id);
				fournisseurs.add(fournisseur);
				}
			for(Fournisseur fournisseur :fournisseurs) {
				System.out.println(fournisseur.getNom() +" "+ fournisseur.getId());
			}
			
			curseur.close();
			monStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
