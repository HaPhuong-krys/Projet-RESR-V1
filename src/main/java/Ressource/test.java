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
		Article art = null;
		try {	
			Connection con = ConnectData.getConnect();
			PreparedStatement s = con.prepareStatement("SELECT * FROM articles.articles WHERE id =2;");
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
				
				System.out.println(art);
			}
			ConnectData.closeConnect(con);
		}catch (SQLException ex) {
            ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
}
