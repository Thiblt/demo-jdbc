package fr.diginamic.props;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class TestConfigurationProps {

	public static void main(String[] args) {
		ResourceBundle config= ResourceBundle.getBundle("test");
		String testBool= config.getString("test.bool");
		
		 Enumeration<String> keys = config.getKeys();

	        // Parcourir toutes les clés et imprimer les paires clé-valeur
	        while (keys.hasMoreElements()) {
	            String key = keys.nextElement();
	            String value = config.getString(key);
	            System.out.println(key + " = " + value);
	        }
	    
	}

}
