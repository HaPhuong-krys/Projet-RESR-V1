package Ressource;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    @Path("list/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Article getArticlesById(@PathParam("id") int id) {
        return article.afficherListArticlesByID(id);
    }
 
   /*
    * 
    * Méthode pour ajouter une nouvelle article à la base de données
    * */ 
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> addArticle(Article art) {
        article.ajouter(art);
        List<Article> list_article = ArticleDAO.getInstance().afficherListArticles(); 
        return list_article;
    }

    /*
     * Méthode pour mettre à jour les articles
     */
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateArticle(@PathParam("id") int id, Article article) {
        ArticleDAO articleDAO = new ArticleDAO();
        article.setId(id);
        articleDAO.upDate(article);
        return Response.ok(article).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteArticle(@PathParam("id") int id) {
        ArticleDAO articleDAO = new ArticleDAO();
        Article article = articleDAO.afficherListArticlesByID(id);
        if (article != null) {
            articleDAO.supprimer(article);
            return Response.ok(article).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}