package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectData;
import Model.Article;
import Model.Categorie;

public class CategorieDAO {
private List<Categorie> cartegories = new ArrayList<>();
	
	public static CategorieDAO getInstance() {
		return new CategorieDAO();
	}

	public List<Categorie> afficherListCategorie() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "Select * from articles.categories";			
			
			ResultSet rs = s.executeQuery(requeteSQL);;
			System.out.println("Resultat de l'execution de la requete de selection:");
			//Article art = new Article();
			
			while (rs.next()) {
				Categorie cat = new Categorie();
				cat.setId(rs.getInt("id"));
				cat.setNom_categorie("nom_categorie");
				
				cartegories.add(cat);		
				
			}
			ConnectData.closeConnect(con);
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartegories;
		}
}
