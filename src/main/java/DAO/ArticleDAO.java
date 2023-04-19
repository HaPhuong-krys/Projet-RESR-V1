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
	public void ajouter(Article t) {
		try {
			Connection con = ConnectData.getConnect();
			String sql = "INSERT INTO articles(libelle, marque, prix, categorie, photo, description) VALUES(?,?,?,?,?,?)";
			PreparedStatement s = con.prepareStatement(sql);
				s.setString(1, t.getLibelle());
				s.setString(2, t.getMarque());
				s.setDouble(3, t.getPrix());
				s.setString(4, t.getCategorie());
				s.setString(5, t.getPhoto());
				s.setString(6, t.getDescription());
			
			s.executeUpdate();
			ConnectData.closeConnect(con);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//@Override
	public void upDate(Article t) {
		try {	
			Connection con = ConnectData.getConnect();
			String sql = "UPDATE articles SET" + " libelle = '" +t.getLibelle() + "'" +
												",marque = '" +t.getMarque() + "'" + ",prix = " +t.getPrix() + ",categorie = '" + t.getCategorie() +"'" + ",photo = '" + t.getPhoto() + "'" +
						"WHERE id = " + t.getId();
			PreparedStatement s = con.prepareStatement(sql);
			ResultSet rs = s.executeQuery(sql);
			
			s.setString(1, t.getLibelle());
	        s.setString(2, t.getMarque());
	        s.setDouble(3, t.getPrix());
	        s.setString(4, t.getCategorie());
	        s.setString((5), t.getPhoto());
			
	        s.executeUpdate();
	        
			ConnectData.closeConnect(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return articles;
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
				art.setDescription("description");
			
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
	
	public List<Article> afficherListArticlesPCPortable() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "PC Portable" + "'";			
			
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
				art.setDescription("description");
			
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
	
	
	public List<Article> afficherListArticlesPCBureau() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "PC de Bureau" + "'";			
			
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
				art.setDescription("description");
			
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
	
	public List<Article> afficherListArticlesAccessoireOrdinateur() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "Accessoire ordinateurs" + "'";			
			
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
				art.setDescription("description");
			
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
	
	
	public List<Article> afficherListArticlesSmartphone() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "Smart Phone" + "'";			
			
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
				art.setDescription("description");
			
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
	
	
	public List<Article> afficherListArticlesTeleFix() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "Tel Fix" + "'";			
			
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
				art.setDescription("description");
			
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
	
	public List<Article> afficherListArticlesAccessTel() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "Accessoire telephone" + "'";			
			
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
				art.setDescription("description");
			
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
	
	
	public List<Article> afficherListArticlesDisque() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "Disque Dur" + "'";			
			
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
				art.setDescription("description");
			
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
	
	
	public List<Article> afficherListArticlesUSB() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "Cle USB" + "'";			
			
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
				art.setDescription("description");
			
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
	
	public List<Article> afficherListArticlesStockage() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "Accessoire stockage" + "'";			
			
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
				art.setDescription("description");
			
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
		Article art = new Article();
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "SELECT * FROM articles.articles WHERE id=" + id;			
			
			ResultSet rs = s.executeQuery(requeteSQL);
			
			if (rs.next()) {
				art = new Article();
				art.setId(rs.getInt("id"));
				art.setLibelle(rs.getString("libelle"));
				art.setMarque(rs.getString("marque"));
				art.setPrix(rs.getDouble("prix"));
				art.setCategorie(rs.getString("categorie"));
				art.setPhoto(rs.getString("photo"));
				
			}
			ConnectData.closeConnect(con);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return art;
		}
}	
