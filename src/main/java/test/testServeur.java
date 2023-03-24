package test;

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

//http://localhost:8080/Projet-REST-V1/test
@Path("test")
public class testServeur {
	@GET
	
	@Produces(MediaType.TEXT_PLAIN)
	public String getHelloWorld() {
	return "Hello World";
	}
}
