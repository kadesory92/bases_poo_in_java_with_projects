package com.principal;

import java.sql.Connection;
import java.util.List;

import com.model.Categorie;
import com.model.Produit;
import com.service.SingletonConnection;

import service.CatalogueImp;

public class Principal {

	public static void main(String[] args) {
		//Connection conn=SingletonConnection.getConnection();
		CatalogueImp calog=new CatalogueImp();
		
		
		/*
		 * calog.addCategories(new Categorie("Imprimante")); calog.addCategories(new
		 * Categorie("Cable")); calog.addCategories(new Categorie("Ordinateur"));
		 * calog.addCategories(new Categorie("Routeur"));
		 */
		 
		 
		/*
		 * calog.addProduits(new Produit("P01", "SAMSUNG", 100, 200), 1);
		 * calog.addProduits(new Produit("P02", "HP", 100, 70), 3);
		 * calog.addProduits(new Produit("P03", "DEL", 400, 100), 4);
		 * calog.addProduits(new Produit("P04", "ACER", 340, 70), 3);
		 * calog.addProduits(new Produit("P05", "HP", 80, 70), 5); calog.addProduits(new
		 * Produit("P06", "COMPAQ", 80, 70), 5);
		 */
		 
		List<Categorie> cats=calog.getAllCategories();
		for(Categorie c: cats) {
			System.out.println(c.toString());
		}
		
		System.out.println(".................................................."); 
		
		List<Produit> prod=calog.getProduitsParCat(1);
		for(Produit p: prod) {
		 System.out.println(p.getNomProd());
		}
		
		System.out.println("..................................................");
		
		List<Categorie> cat=calog.getAllCategories();
		for(Categorie ca: cat) {
			System.out.println(ca.getNomCat());
		}
	}

}
