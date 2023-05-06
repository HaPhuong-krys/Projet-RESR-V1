package Ressource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ArticleDAO;
import DAO.CategorieDAO;
import DataBase.ConnectData;
import Model.Article;
import Model.Categorie;

public class test {
	
	

	public static void main(String[] args) {
		ArticleDAO articleDao = new ArticleDAO();
		ArticlesRessource ar = new ArticlesRessource();
		
	    Article t = new Article(22,"test 16", "ajouter marque 16", 316, "ajoute cat 16","photo 16", "des 16");
//	    ar.addArticle(t);
//	    List<Article> articles = ar.article.afficherListArticles();
//	    List<Article> pcport = articleDao.afficherListArticlesPCPortable();
// 	    for(Article a : articles) {
//	        System.out.println(a);
//	    }
	    
	    //TEST UPDATE
	    
	    articleDao.getInstance().upDate(t);
		
// 	    CategorieDAO catDao = new CategorieDAO();
// 	    List<Categorie> cat = catDao.afficherListCategorie();
// 	    for(Categorie c: cat) {
// 	    	System.err.println();
// 	    }
//		try {	
//			
//			List<Article> articles = new ArrayList<>();
//			Connection con = ConnectData.getConnect();
//			Statement s = con.createStatement();
//			String requeteSQL = "Select * from articles Where categorie =" + "'" + "PCPortable" + "'";			
//			
//			ResultSet rs = s.executeQuery(requeteSQL);
//			System.out.println(requeteSQL);
//			System.out.println("Resultat de l'execution de la requete de selection:");
//			//Article art = new Article();
//			
//			while (rs.next()) {
//				Article art = new Article();
//				art.setId(rs.getInt("id"));
//				art.setLibelle(rs.getString("libelle"));
//				art.setMarque(rs.getString("marque"));
//				art.setPrix(rs.getDouble("prix"));
//				art.setCategorie(rs.getString("categorie"));
//				art.setPhoto(rs.getString("photo"));
//				art.setDescription("description");
//			
//				articles.add(art);		
//				
//			}
//			for (Article ar : articles) {
//				System.out.println(ar);
//			}
//			ConnectData.closeConnect(con);
//			
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
	}
}
