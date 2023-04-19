package Ressource;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import DAO.ArticleDAO;
import DataBase.ConnectData;
import Model.Article;


@Path("/articles")
public class ArticlesRessource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    

    ArticleDAO article = new ArticleDAO();
    

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticle() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticles();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    
    @GET
    @Path("/list/PC_Portable")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticlePcPortable() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesPCPortable();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    
    @GET
    @Path("/list/PC_Bureau")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticlePcBureau() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesPCBureau();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    @GET
    @Path("/list/accessoire_ordi")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticleAccessoireOrdinateur() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesAccessoireOrdinateur();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
   
    
    @GET
    @Path("/list/smartphone")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticleSmartphone() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesSmartphone();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    @GET
    @Path("/list/telephoneFix")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticleTelFix() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesTeleFix();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    @GET
    @Path("/list/accessoire_tel")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticleAccessoireTel() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesAccessTel();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    @GET
    @Path("/list/Disque_dur")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticleDisque() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesDisque();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    @GET
    @Path("/list/USB")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticleUSB() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesUSB();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    @GET
    @Path("/list/accessoire_stock")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Article> getArticleStockage() {
    	List<Article> list_article = ArticleDAO.getInstance().afficherListArticlesStockage();
        if(list_article==null)
            throw new RuntimeException("Get: Todo with not found");
        return list_article;
    }  
    
    
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Article getArticlesById(@PathParam("id") int id) {
        return article.afficherListArticlesByID(id);
    }
 
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> addArticle(Article art) {
        article.ajouter(art);
        List<Article> list_article = ArticleDAO.getInstance().afficherListArticles(); 
        return list_article;
    }

    
//    @GET
//    @Path("/modifier-article-forme")
//    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
//    public String getForme(@QueryParam("id") int id) {
//        Article art = article.afficherListArticlesByID(id);
//       
//
//        StringBuilder html = new StringBuilder();
//        html.append("<form method=\"post\" action=\"/Projet-REST-V1/articles/modifier-article-action").append("\">");
//        html.append("<label>Libellé :</label>");
//        html.append("<input type=\"text\" name=\"libelle\" value=\"").append(art.getLibelle()).append("\"><br>");
//        html.append("<label>Marque :</label>");
//        html.append("<input type=\"text\" name=\"marque\" value=\"").append(art.getMarque()).append("\"><br>");
//        html.append("<label>Prix :</label>");
//        html.append("<input type=\"number\" name=\"prix\" value=\"").append(art.getPrix()).append("\"><br>");
//        html.append("<label>Catégorie :</label>");
//        html.append("<input type=\"text\" name=\"categorie\" value=\"").append(art.getCategorie()).append("\"><br>");
//        html.append("<label>Photo :</label>");
//        html.append("<input type=\"text\" name=\"photo\" value=\"").append(art.getPhoto()).append("\"><br>");
//        html.append("<input type=\"submit\" value=\"Enregistrer\">");
//        html.append("</form>");
//        
//        return html.toString();
//    }
//    
//    @Path("/modifier-article-action")
//    @POST
//    @Produces(MediaType.TEXT_HTML+ ";charset=UTF-8")
//    public String modifierArticle(@FormParam("id") int id,
//                                  @FormParam("libelle") String libelle,
//                                  @FormParam("marque") String marque,
//                                  @FormParam("prix") double prix,
//                                  @FormParam("categorie") String categorie,
//                                  @FormParam("photo") String photo,
//    							  @FormParam("description") String description){
//        Article art = new Article(id, libelle, marque, prix, categorie, photo, description);
//        article.upDate(art);
//        StringBuilder retour = new StringBuilder("<h1>Article modifié avec succès !</h1>");
//        retour.append("<a href='/Projet-REST-V1/articles/list").append("'>Retour</a>");
//        return retour.toString();
//        
//       // return("<h1>Article modifié avec succès !</h1>");
//    }

    
	
    

}