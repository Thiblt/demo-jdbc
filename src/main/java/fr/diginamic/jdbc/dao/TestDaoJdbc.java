package fr.diginamic.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDaoJdbc {

	public static void main(String[] args) {
		FournisseurDaoJbdc OperationFournisseur=new FournisseurDaoJbdc();
		OperationFournisseur.insert(new Fournisseur("France de matériaux", 5));
		List<Fournisseur>fournisseurs=OperationFournisseur.extraire();
		for(Fournisseur fournisseur :fournisseurs) {
			System.out.println(fournisseur.getNom() +" "+ fournisseur.getId());
		}
		OperationFournisseur.update("France de matériaux","France matériaux");
		fournisseurs=OperationFournisseur.extraire();
		for(Fournisseur fournisseur :fournisseurs) {
			System.out.println(fournisseur.getNom() +" "+ fournisseur.getId());
		}
		OperationFournisseur.delete(new Fournisseur("France matériaux", 5));
		fournisseurs=OperationFournisseur.extraire();
		for(Fournisseur fournisseur :fournisseurs) {
			System.out.println(fournisseur.getNom() +" "+ fournisseur.getId());
		}

	}

}
