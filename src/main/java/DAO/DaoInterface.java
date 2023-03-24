package DAO;

import java.util.ArrayList;

import Model.Article;

public interface DaoInterface {
	public int ajouter(Article t);
	public int upDate (Article t);
	public int supprimer (Article t);
	public ArrayList<Article> selectAll();
	public Article selectById(Article t);
	public ArrayList<Article> selectByCondition(String s);

}
