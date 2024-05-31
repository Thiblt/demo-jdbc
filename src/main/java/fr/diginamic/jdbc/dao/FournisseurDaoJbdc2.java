package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJbdc2 implements FournisseurDao{

	@Override
	public List<Fournisseur> extraire() {
		Connection connection = null;
	    Statement monStatement = null;
		try {
			ResourceBundle config= ResourceBundle.getBundle("database");
			connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			monStatement= connection.createStatement();
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
			return fournisseurs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
	        try {
	            if (monStatement != null) {
	                monStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	

	@Override
	public void insert(Fournisseur fournisseur) {
		Connection connection = null;
	    PreparedStatement monStatement = null;
		try {
			ResourceBundle config= ResourceBundle.getBundle("database");
			connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			
			monStatement= connection.prepareStatement("INSERT INTO fournisseur (nom, id) VALUES (?,?)");
			monStatement.setString(1,fournisseur.getNom());
			monStatement.setInt(2, fournisseur.getId());
			int result=monStatement.executeUpdate();
			
			

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
	        try {
	            if (monStatement != null) {
	                monStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
		
	

	@Override
	public int update(String ancienNom, String nouveauNom) {
		Connection connection = null;
	    PreparedStatement monStatement = null;
		try {
		ResourceBundle config= ResourceBundle.getBundle("database");
		connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
		monStatement= connection.prepareStatement("UPDATE fournisseur set nom=? WHERE nom=?");
		monStatement.setString(1,nouveauNom);
		monStatement.setString(2, ancienNom);
		int result=monStatement.executeUpdate();
		
		return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
	        try {
	            if (monStatement != null) {
	                monStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	

	@Override
	public boolean delete(Fournisseur fournisseur) {
		Connection connection = null;
	    PreparedStatement monStatement = null;
		try {
			ResourceBundle config= ResourceBundle.getBundle("database");
			connection = DriverManager.getConnection(config.getString("database.url"), config.getString("database.user"), config.getString("database.pwd"));
			monStatement= connection.prepareStatement("DELETE FROM fournisseur where id=?");
			monStatement.setInt(1, fournisseur.getId());
			int result=monStatement.executeUpdate();
			
			return result==1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
	        try {
	            if (monStatement != null) {
	                monStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}

