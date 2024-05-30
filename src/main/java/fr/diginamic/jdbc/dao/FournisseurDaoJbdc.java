package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJbdc implements FournisseurDao{

	@Override
	public List<Fournisseur> extraire() {
		try {
			ResourceBundle config= ResourceBundle.getBundle("database");
			Connection connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			Statement monStatement= connection.createStatement();
			ResultSet curseur = monStatement.executeQuery("SELECT * FROM fournisseur");
			ArrayList<Fournisseur>fournisseurs= new ArrayList<>();
			
			while
				(curseur.next()) {
				int id= curseur.getInt("ID");
				String nom= curseur.getString("NOM");
				Fournisseur fournisseur= new Fournisseur(nom,id);
				fournisseurs.add(fournisseur);
				}
			
			curseur.close();
			monStatement.close();
			connection.close();
			return fournisseurs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		try {
			ResourceBundle config= ResourceBundle.getBundle("database");
			Connection connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			Statement monStatement= connection.createStatement();
			int result=monStatement.executeUpdate("INSERT INTO fournisseur (nom, id) VALUES ('" + fournisseur.getNom() + "'," + fournisseur.getId() + ")");
			
			monStatement.close();
			connection.close();
			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		try {
		ResourceBundle config= ResourceBundle.getBundle("database");
		Connection connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
		Statement monStatement= connection.createStatement();
		int result=monStatement.executeUpdate("UPDATE fournisseur set nom='"+nouveauNom+ "' WHERE nom='"+ancienNom+"'");
		
		monStatement.close();
		connection.close();
		
		return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		try {
			ResourceBundle config= ResourceBundle.getBundle("database");
			Connection connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			Statement monStatement= connection.createStatement();
			int result=monStatement.executeUpdate("DELETE FROM fournisseur where id="+ fournisseur.getId());
			
			monStatement.close();
			connection.close();
			
			return result==1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
