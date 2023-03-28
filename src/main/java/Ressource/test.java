package Ressource;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		List<Article> arti = new ArrayList<>();
		try {	
			Connection con = ConnectData.getConnect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM articles.articles");
			ResultSet rs = s.executeQuery();	
			
			System.out.println(s);
			while (rs.next()) {
				Article art = new Article();
				art.setId(rs.getInt("id"));
				art.setLibelle(rs.getString("libelle"));
				art.setMarque(rs.getString("marque"));
				art.setPrix(rs.getDouble("prix"));
				art.setCategorie(rs.getString("categorie"));
				art.setPhoto(rs.getString("photo"));
			
				arti.add(art);	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Article a:arti) {
			System.out.println(a);
		}
	}
		
}
