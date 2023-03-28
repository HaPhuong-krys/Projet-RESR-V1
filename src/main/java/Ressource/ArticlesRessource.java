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
    
    // Return the list of articles for applications
    @GET
    @Path("/list")
    @Produces({ MediaType.TEXT_HTML})
    public String getArticles() {
       List<Article> list_article =  article.afficherListArticles();
       StringBuilder sb = new StringBuilder();
       sb.append("<table>");
       sb.append("<tr>");
       sb.append("<th> ID </th>");
       sb.append("<th> Libelle </th>");
       sb.append("<th> Marque </th>");
       sb.append("<th> Prix </th>");
       sb.append("<th> Caterogies </th>");
       sb.append("<th> Photo </th>");
       sb.append("</tr>");
       
       for (Article art : list_article) {
    	   sb.append("<tr>");
           sb.append("<td>").append(art.getId()).append("</td>");
           sb.append("<td>").append(art.getLibelle()).append("</td>");
           sb.append("<td>").append(art.getMarque()).append("</td>");
           sb.append("<td>").append(art.getPrix()).append("</td>");
           sb.append("<td>").append(art.getCategorie()).append("</td>");
           sb.append("<td>").append(art.getPhoto()).append("</td>");
           sb.append("</tr>");
       }
       sb.append("</table>");
       return sb.toString();
    }
    
    
    
    
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Article getArticlesById(@PathParam("id") int id) {
        return article.afficherListArticlesByID(id);
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
    
    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> updateData(Article articleUpdate) {
    	return article.upDate(articleUpdate);       
    }
    
//    @POST
//    @Produces(MediaType.TEXT_HTML)
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void newArticle(@FormParam("id") int id,
//            @FormParam("libelle") String libelle,
//            @FormParam("marque") String marque,
//            @FormParam("prix") double prix,
//            @FormParam("categorie") String categorie,
//            @FormParam("photo") String photo,            
//            @Context HttpServletResponse servletResponse) throws IOException {
//        
//        Article art = new Article(id, libelle, marque, prix, categorie, photo);
//
//        //ArticlesDao.instance.getModel().put(id, art);
//
//        servletResponse.sendRedirect("../create_article.html");
//    }
}