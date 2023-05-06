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

import DAO.UserDAO;
import DataBase.ConnectData;
import Model.User;

import DAO.UserDAO;

@Path("/users")
public class UsersRessource {

	 @Context
	    UriInfo uriInfo;
	    @Context
	    Request request;

	    UserDAO users = UserDAO.getInstance();

	    // Return the list of users
	    @GET
	    @Path("/list")
	    @Produces({ MediaType.TEXT_HTML + ";charset=UTF-8" })
	    public String getUsers() {
	        List<User> list_user = users.afficherListUser();
	        StringBuilder sb = new StringBuilder();
	        sb.append("<table>");
	        sb.append("<tr>");
	        sb.append("<th> ID </th>");
	        sb.append("<th> Firstname </th>");
	        sb.append("<th> Lastname </th>");
	        sb.append("<th> Email </th>");
	        sb.append("<th> Password </th>");
	        sb.append("<th> Role </th>");
	        sb.append("</tr>");

	        for (User user : list_user) {
	            sb.append("<tr>");
	            sb.append("<td>").append(user.getId_user()).append("</td>");
	            sb.append("<td>").append(user.getFirstname()).append("</td>");
	            sb.append("<td>").append(user.getLastname()).append("</td>");
	            sb.append("<td>").append(user.getEmail()).append("</td>");
	            sb.append("<td>").append(user.getPassword()).append("</td>");
	            sb.append("<td>").append(user.getRole()).append("</td>");
	            sb.append("<td>");
	            sb.append("<a href='/Projet-REST-V1/users/modifier-user-forme?id=").append(user.getId_user()).append("'>Modifier</a>");
	            sb.append("</td>");
	            sb.append("</tr>");
	        }
	        sb.append("</table>");
	        return sb.toString();
	    }

	    @GET
	    @Path("/{id}")
	    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	    public User getUserById(@PathParam("id") int id) {
	        return users.afficherListUserByID(id);
	    }

	    @GET
	    @Path("/modifier-user-forme")
	    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
	    public String getForme(@QueryParam("id") int id) {
	        User user = users.afficherListUserByID(id);

	        StringBuilder html = new StringBuilder();
	        html.append("<form method=\"post\" action=\"/Projet-REST-V1/users/modifier-user-action").append("\">");
	        html.append("<label>Id :</label>");
	        html.append("<input type=\"number\" name=\"id\" value=\"").append(user.getId_user()).append("\"><br>");
	        html.append("<label>Firstname :</label>");
	        html.append("<input type=\"text\" name=\"firstname\" value=\"").append(user.getFirstname()).append("\"><br>");
	        html.append("<label>Lastname :</label>");
	        html.append("<input type=\"text\" name=\"lastname\" value=\"").append(user.getLastname()).append("\"><br>");
	        html.append("<label>Email :</label>");
	        html.append("<input type=\"email\" name=\"email\" value=\"").append(user.getEmail()).append("\"><br>");
	        html.append("<label>Password :</label>");
	        html.append("<input type=\"password\" name=\"password\" value=\"").append(user.getPassword()).append("\"><br>");
	        html.append("<label>Role :</label>");
	        html.append("<input type=\"text\" name=\"role\" value=\"").append(user.getRole()).append("\"><br>");
	        html.append("<input type=\"submit\" value=\"Modifier\">");
	        html.append("</form>");

	        return html.toString();
	    }

	    @Path("/modifier-user-action")
	    @POST
	    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
	    public String modifierUser(@FormParam("id") int id, @FormParam("firstname") String firstname,
	            @FormParam("lastname") String lastname, @FormParam("email") String email,
	            @FormParam("password") String password, @FormParam("role") String role) {
	        User user = new User(id, firstname, lastname, email, password, role);
	        users.upDate(user);
	        return ("<h1>Utilisateur modifié avec succès !</h1>");
	    }

	    @POST
	    @Path("/ajouter")
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
	    public String ajouterUser(@FormParam("id_user") int id_user, @FormParam("firstname") String firstname,
	            @FormParam("lastname") String lastname, @FormParam("email") String email,
	            @FormParam("password") String password, @FormParam("role") String role,
	            @Context HttpServletResponse servletResponse) throws IOException {
	        User user = new User(id_user, firstname, lastname, email, password, role);
	        users.ajouter(user);
	        return ("<h1>Utilisateur ajouté avec succès !</h1>");
	    }

	    @POST
	    @Path("/supprimer/{id}")
	    @Produces(MediaType.TEXT_HTML + ";charset=UTF-8")
	    public String supprimerUser(@PathParam("id") int id) {
	        User user = users.afficherListUserByID(id);
	        users.supprimer(user);
	        return ("<h1>Utilisateur supprimé avec succès !</h1>");
	    }

	    @POST
	    @Path("/login")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response login(User user) {
	        User foundUser = users.findUserByUsername(user.getEmail());
	        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
	            return Response.ok(foundUser).build();
	        } else {
	            return Response.status(Response.Status.UNAUTHORIZED).build();
	        }
	    }
}
