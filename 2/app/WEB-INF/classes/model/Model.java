package model;

import java.util.List;
import java.net.*;
import java.sql.*;

public class Model
{    
	Statement stmt;               						
	ResultSet rs;	
	PreparedStatement statement;
	Connection con;
		
	public Model()
	{
		try 
		{
			String url = "jdbc:mysql://localhost/test?serverTimezone=Europe/Moscow&useSSL=false";
			String username = "Kuzmin";
			String password = "trewolfol123";
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			con = DriverManager.getConnection(url, username, password);	
			
		} catch (Exception ex) { System.out.println(ex); }
						
	}
	public String addData(String login, String password)
	{
		try 
		{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, /*ResultSet.CONCUR_READ_ONLY,*/ ResultSet.CONCUR_UPDATABLE);  
			rs = stmt.executeQuery("SELECT * FROM users");	

			String query = "INSERT INTO users(login, password) VALUES (?,?)";
			statement = con.prepareStatement(query);
			statement.setString(1, login);
			statement.setString(2, password);
			statement.execute();

		} catch (Exception e) { System.out.println("ERROR in class MODEL: " + e); return "e:\t" + e; }
		return "ok";
	}

	public String checkData(String login) {
		try 
		{
			String query = "select * from users where login = '?'";
			statement = con.prepareStatement(query);
			statement.setString(1, login);
			statement.execute();

		} catch (Exception e) { System.out.println("ERROR in class MODEL: " + e); return "e:\t" + e; }
		return "ok";
	}
	
	public void finalize()
	{
		try
		{
			rs.close();
			stmt.close();
		} catch (Exception e) { System.out.println(e); }
	}		
}