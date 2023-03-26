package DAO;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import DataBase.ConnectData;
import Model.*;

public class ArticleDAO  {
	
	private List<Article> articles = new ArrayList<>();

	public static ArticleDAO getInstance() {
		return new ArticleDAO();
	}
	//@Override
	public int ajouter(Article t) {
		try {
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			//String sql = "INSERT INTO articles VALUES(\"test4\", \"test4\", 30.30, \"D\", \"photo\")";
			String sql = "INSERT INTO articles VALUES(" +t.getId() + ",'" + t.getLibelle() +"','" + t.getMarque() +"'," + t.getPrix() +",'" +t.getCategorie() +"','" + t.getPhoto()+"')";
			System.out.println(sql);
			
			int resultat = s.executeUpdate(sql);
			ConnectData.closeConnect(con);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	//@Override
	public List<Article> upDate(int id, Article t) {
		try {	
			Connection con = ConnectData.getConnect();
			PreparedStatement s = con.prepareStatement("UPDATE mytable SET libelle=?, marque=?, prix=?, categorie=?, photo=? WHERE id=?");
			ResultSet rs = null; 
//			String sql = "UPDATE articles SET" + " libelle = '" +t.getLibelle() + "'" +
//												",marque = '" +t.getMarque() + "'" + ",prix = " +t.getPrix() + ",categorie = '" + t.getCategorie() +"'" + ",photo = '" + t.getPhoto() + "'" +
//						"WHERE id = " + t.getId();
//			
			s.setString(1, t.getLibelle());
	        s.setString(2, t.getMarque());
	        s.setDouble(3, t.getPrix());
	        s.setString(4, t.getCategorie());
	        s.setString((5), t.getPhoto());
			
			int rowUpdate = s.executeUpdate();
			
			if(rowUpdate == 1) {
				s = con.prepareStatement("SELECT * FROM mytable WHERE id=?");
				s.setInt(1, id);
	            rs = s.executeQuery();
	            while (rs.next()) {
					Article updateArticle = new Article();
					updateArticle.setId(rs.getInt("id"));
					updateArticle.setLibelle(rs.getString("libelle"));
					updateArticle.setMarque(rs.getString("marque"));
					updateArticle.setPrix(rs.getDouble("prix"));
					updateArticle.setCategorie(rs.getString("categorie"));
					updateArticle.setPhoto(rs.getString("photo"));
				
					articles.add(updateArticle);	
				}
			}
			ConnectData.closeConnect(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	//@Override
	public int supprimer(Article t) {
		try {
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String sql = "DELETE from articles" + 
						" WHERE id = " + t.getId();
						
			//System.out.println(sql);
			int res = s.executeUpdate(sql);
			ConnectData.closeConnect(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//@Override
	public ArrayList<Article> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Article selectById(Article t) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public ArrayList<Article> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Article> afficherListArticles() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles";			
			
			ResultSet rs = s.executeQuery(requeteSQL);;
			System.out.println("Resultat de l'execution de la requete de selection:");
			//Article art = new Article();
			
			while (rs.next()) {
				Article art = new Article();
				art.setId(rs.getInt("id"));
				art.setLibelle(rs.getString("libelle"));
				art.setMarque(rs.getString("marque"));
				art.setPrix(rs.getDouble("prix"));
				art.setCategorie(rs.getString("categorie"));
				art.setPhoto(rs.getString("photo"));
			
				articles.add(art);		
				
			}
			ConnectData.closeConnect(con);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
		}
	
	
	public Article afficherListArticlesByID(int id) {
		
		Article art = null;
		try {	
			Connection con = ConnectData.getConnect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM articles.articles WHERE id =? ");
			ResultSet rs = s.executeQuery();
			System.out.println("Resultat de l'execution de la requete de selection:");
			//Article art = new Article();
			
			if(rs.next()) {
				art= new Article();
				art.setId(rs.getInt("id"));
				art.setLibelle(rs.getString("libelle"));
				art.setMarque(rs.getString("marque"));
				art.setPrix(rs.getDouble("prix"));
				art.setCategorie(rs.getString("categorie"));
				art.setPhoto(rs.getString("photo"));
				
			}
			ConnectData.closeConnect(con);
		}catch (SQLException ex) {
            ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return art;
		}
}	
