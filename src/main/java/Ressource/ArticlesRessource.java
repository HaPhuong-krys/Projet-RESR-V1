package Ressource;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
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
    
    /*
    // Return the list of articles to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Article> getArticlesBrowser() {
        List<Article> articles = new ArrayList<Article>();
        articles.addAll(article.testerBD());
        return articles;
    }*/
    
    // Return the list of articles for applications
    @GET
    @Path("/list")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Article> getArticles() {
    	List<Article> articles = new ArrayList<Article>();
        articles.addAll(article.afficherListArticles());
        return articles;
    }

    
    // returns the number of articles
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = 0;//ArticlesDao.instance.getModel().size();
        return String.valueOf(count);
    }

    
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newArticle(@FormParam("id") int id,
            @FormParam("libelle") String libelle,
            @FormParam("marque") String marque,
            @FormParam("prix") double prix,
            @FormParam("categorie") String categorie,
            @FormParam("photo") String photo,            
            @Context HttpServletResponse servletResponse) throws IOException {
        
        Article art = new Article(id, libelle, marque, prix, categorie, photo);

        //ArticlesDao.instance.getModel().put(id, art);

        servletResponse.sendRedirect("../create_article.html");
    }

}