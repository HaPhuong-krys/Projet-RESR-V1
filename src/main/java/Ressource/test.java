package Ressource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectData;
import Model.Article;

public class test {
	
	//private List<Article> articles = new ArrayList<>();

	public static void main(String[] args) {
	    List<Article> articles = new ArrayList<>();

		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "SELECT * FROM articles";			
			
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
			System.out.println(articles);
			ConnectData.closeConnect(con);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return articles;
		}
}
