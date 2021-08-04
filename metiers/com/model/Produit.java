package com.model;

import java.io.Serializable;

public class Produit implements Serializable {
	private String idProd;
	private String nomProd;
	private double prix;
	private int quantite;
	private Categorie categorie;
	
	public Produit() {
		super();
	}
	
	public Produit(String idProd, String nomProd, double prix, int quantite) {
		super();
		this.idProd = idProd;
		this.nomProd = nomProd;
		this.prix = prix;
		this.quantite = quantite;
		//this.categorie = categorie;
	}

	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	

}
