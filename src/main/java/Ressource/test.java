package Ressource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ArticleDAO;
import DataBase.ConnectData;
import Model.Article;

public class test {
	
	

	public static void main(String[] args) {
		ArticleDAO articleDao = new ArticleDAO();
//	    Article t = new Article(6,"test ajouter TEST", "ajouter marque", 300.90, "ajoute cat","photo", "des");
//	    articleDao.ajouter(t);
//	    List<Article> articles = articleDao.afficherListArticles();
//	    List<Article> pcport = articleDao.afficherListArticlesPCPortable();
// 	    for(Article a : pcport) {
//	        System.out.println(a);
//	    }
		
		try {	
			
			List<Article> articles = new ArrayList<>();
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles Where categorie =" + "'" + "PCPortable" + "'";			
			
			ResultSet rs = s.executeQuery(requeteSQL);
			System.out.println(requeteSQL);
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
			for (Article ar : articles) {
				System.out.println(ar);
			}
			ConnectData.closeConnect(con);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
