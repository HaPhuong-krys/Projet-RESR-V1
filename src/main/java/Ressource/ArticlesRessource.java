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
    @Produces({ MediaType.TEXT_HTML+ ";charset=UTF-8"})
    public String getArticles() {
       List<Article> list_article =  article.afficherListArticles();
       StringBuilder sb = new StringBuilder();
       sb.append("<table>");
       sb.append("<tr>");
       sb.append("<th> ID </th>");
       sb.append("<th> Libellé </th>");
       sb.append("<th> Marque </th>");
       sb.append("<th> Prix </th>");
       sb.append("<th> Caterogies </th>");
       sb.append("<th> Photo </th>");
       sb.append("<th> Fonctionalité </th>");
       sb.append("</tr>");
       
       for (Article art : list_article) {
    	   sb.append("<tr>");
           sb.append("<td>").append(art.getId()).append("</td>");
           sb.append("<td>").append(art.getLibelle()).append("</td>");
           sb.append("<td>").append(art.getMarque()).append("</td>");
           sb.append("<td>").append(art.getPrix()).append("</td>");
           sb.append("<td>").append(art.getCategorie()).append("</td>");
           sb.append("<td>").append(art.getPhoto()).append("</td>");
           sb.append("<td>");
           sb.append("<a href='/Projet-REST-V1/articles/modifier-article-forme?id=").append(art.getId()).append("'>Modifier</a>");
           sb.append("</td>");
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
 
    @GET
    @Path("/modifier-article-forme")
    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
    public String getForme(@QueryParam("id") int id) {
        Article art = article.afficherListArticlesByID(id);
       

        StringBuilder html = new StringBuilder();
        html.append("<form method=\"post\" action=\"/Projet-REST-V1/articles/modifier-article-action").append("\">");
        html.append("<label>Libellé :</label>");
        html.append("<input type=\"text\" name=\"libelle\" value=\"").append(art.getLibelle()).append("\"><br>");
        html.append("<label>Marque :</label>");
        html.append("<input type=\"text\" name=\"marque\" value=\"").append(art.getMarque()).append("\"><br>");
        html.append("<label>Prix :</label>");
        html.append("<input type=\"number\" name=\"prix\" value=\"").append(art.getPrix()).append("\"><br>");
        html.append("<label>Catégorie :</label>");
        html.append("<input type=\"text\" name=\"categorie\" value=\"").append(art.getCategorie()).append("\"><br>");
        html.append("<label>Photo :</label>");
        html.append("<input type=\"text\" name=\"photo\" value=\"").append(art.getPhoto()).append("\"><br>");
        html.append("<input type=\"submit\" value=\"Enregistrer\">");
        html.append("</form>");
        
        return html.toString();
    }
    
    @Path("/modifier-article-action")
    @POST
    @Produces(MediaType.TEXT_HTML+ ";charset=UTF-8")
    public String modifierArticle(@FormParam("id") int id,
                                  @FormParam("libelle") String libelle,
                                  @FormParam("marque") String marque,
                                  @FormParam("prix") double prix,
                                  @FormParam("categorie") String categorie,
                                  @FormParam("photo") String photo) {
        Article art = new Article(id, libelle, marque, prix, categorie, photo);
        article.upDate(art);
//        StringBuilder retour = new StringBuilder("<h1>Article modifié avec succès !</h1>");
//        retour.append("<a href='/Projet-REST-V1/articles/list").append("'>Retour</a>");
//        return retour.toString();
        
        return("<h1>Article modifié avec succès !</h1>");
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