package Ressource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import DAO.ArticleDAO;
import DAO.CategorieDAO;
import Model.Article;
import Model.Categorie;


@Path("/categories")
public class CategoriesRessource {
	 @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    
	    CategorieDAO caterogie = new CategorieDAO();
	    
	    @GET
	    @Path("/list")
	    @Produces({MediaType.APPLICATION_JSON})
	    public List<Categorie> getCategorie() {
	    	List<Categorie> list_cats = CategorieDAO.getInstance().afficherListCategorie();
	        if(list_cats==null)
	            throw new RuntimeException("Get: Todo with not found");
	        return list_cats;
	        }
}
