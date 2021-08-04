package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.IMetier;
import com.model.Categorie;
import com.model.Produit;
import com.service.SingletonConnection;

public class CatalogueImp implements IMetier{

	@Override
	public void addCategories(Categorie c) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into CATEGORIE(nom) values(?)");
			ps.setString(1, c.getNomCat());
			ps.executeUpdate();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProduits(Produit p, int idCat) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into PRODUIT values(?,?,?,?,?)");
			ps.setString(1, p.getIdProd());
			ps.setString(2, p.getNomProd());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.setInt(5, idCat);
			ps.executeUpdate();
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> getProduitsParMC(String mc) {
		List<Produit> prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from PRODUIT where nom like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Produit p=new Produit();
				p.setIdProd(rs.getString("idProd"));
				p.setNomProd(rs.getString("nom"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				
				int idCat=rs.getInt("idCat");
				PreparedStatement ps2=conn.prepareStatement("select * from CATEGORIE where idCat=?");
				ps2.setInt(1, idCat);
				ResultSet rs2=ps2.executeQuery();
				if(rs.next()) {
				 Categorie cat=new Categorie();
				 cat.setIdCat(rs2.getInt("idCat"));
				 cat.setNomCat(rs2.getString("nom"));
				 p.setCategorie(cat);
				 ps2.close();
				}
				prods.add(p);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return prods;
	}

	@Override
	public List<Produit> getProduitsParCat(int idCat) {
		List<Produit> prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from PRODUIT where idCat=?");
			ps.setInt(1, idCat);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Produit p=new Produit();
				p.setIdProd(rs.getString("idProd"));
				p.setNomProd(rs.getString("nom"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				
				PreparedStatement ps2=conn.prepareStatement("select * from CATEGORIE where idCat=?");
				ps2.setInt(1, idCat);
				ResultSet rs2=ps2.executeQuery();
				if(rs.next()) {
				 Categorie cat=new Categorie();
				 cat.setIdCat(rs2.getInt("idCat"));
				 cat.setNomCat(rs2.getString("nom"));
				 p.setCategorie(cat);
				 ps2.close();
				}
				prods.add(p);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> cats=new ArrayList<Categorie>();
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from CATEGORIE");
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Categorie c=new Categorie();
				c.setIdCat(rs.getInt("idCat"));
				c.setNomCat(rs.getString("nom"));
				cats.add(c);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cats;
	}

	@Override
	public Categorie getCategorie(int idCat) {
		Categorie cats=null;
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from CATEGORIE where idCat=?");
			ps.setInt(1, idCat);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				cats=new Categorie();
				cats.setIdCat(rs.getInt("idCat"));
				cats.setNomCat(rs.getString("nom"));
				List<Produit> prod=this.getProduitsParCat(idCat);
			}
			ps.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cats;
	}

}
