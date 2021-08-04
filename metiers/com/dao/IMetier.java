package com.dao;

import java.util.List;

import com.model.Categorie;
import com.model.Produit;

public interface IMetier {
   public void addCategories(Categorie c);
   public void addProduits(Produit p, int idCat);
   public List<Produit> getProduitsParMC(String mc);
   public List<Produit> getProduitsParCat(int idCat);
   public List<Categorie> getAllCategories();
   public Categorie getCategorie(int idCat);
}
