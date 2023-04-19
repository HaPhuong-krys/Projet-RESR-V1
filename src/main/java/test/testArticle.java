package test;

import DAO.ArticleDAO;
import Model.Article;

public class testArticle {
	public static void main(String[] args) {
		Article a1 = new Article(5, "test5", "TES5", 10.31, "A", "photo5", "des");
		
		ArticleDAO.getInstance().supprimer(a1);
		
	}

}
