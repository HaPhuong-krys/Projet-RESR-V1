package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectData;
import Model.Article;
import Model.User;

public class UserDAO {

private List<User> users = new ArrayList<>();
	
	public static UserDAO getInstance() {
		return new UserDAO();
	}
	
	public int ajouter(User t) {
		try {
			Connection con = ConnectData.getConnect();
			String sql = "INSERT INTO users (id_user, firstname, lastname, email, password, role) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getId_user());
			ps.setString(2, t.getFirstname());
			ps.setString(3, t.getLastname());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getPassword());
			ps.setString(6, "client"); // valeur fixe pour la colonne "role"
			
			int result = ps.executeUpdate();
			ConnectData.closeConnect(con);
			return result;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void upDate(User t) {
		try {	
			Connection con = ConnectData.getConnect();
			String sql = "UPDATE users SET firstname=?, lastname=?, email=?, password=? WHERE id_user=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getFirstname());
			ps.setString(2, t.getLastname());
			ps.setString(3, t.getEmail());
			ps.setString(4, t.getPassword());
			ps.setInt(5, t.getId_user());
			
			int result = ps.executeUpdate();
			ConnectData.closeConnect(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int supprimer(User t) {
		try {
			Connection con = ConnectData.getConnect();
			String sql = "DELETE FROM users WHERE id_user=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getId_user());
						
			int result = ps.executeUpdate();
			ConnectData.closeConnect(con);
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public User selectById(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<User> afficherListUser() {
		try {	
			Connection con = ConnectData.getConnect();
			Statement s = con.createStatement();
			String requeteSQL = "SELECT * FROM users";			
			
			ResultSet rs = s.executeQuery(requeteSQL);;
			System.out.println("Resultat de l'execution de la requete de selection:");
			
			while (rs.next()) {
				User user = new User();
				user.setId_user(rs.getInt("id_user"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				users.add(user);		
			}
			ConnectData.closeConnect(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User afficherListUserByID(int id) {
		User user = new User();
		
		try {	
			Connection con = ConnectData.getConnect();
			String requeteSQL = "SELECT * FROM users WHERE id_user=?";
			PreparedStatement ps = con.prepareStatement(requeteSQL);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				user.setId_user(rs.getInt("id_user"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
			ConnectData.closeConnect(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	/*fonction pour retrouver un user*/
	public User findUserByUsername(String username) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    User user = null;

	    try {
	        connection = ConnectData.getConnect();
	        String sql = "SELECT * FROM users WHERE email = ?";
	        statement = connection.prepareStatement(sql);
	        statement.setString(1, username);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int id = resultSet.getInt("id_user");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String email = resultSet.getString("email");
	            String password = resultSet.getString("password");
	            String role = resultSet.getString("role");

	            user = new User(id, firstname, lastname, email, password, role);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return user;
	}
}
