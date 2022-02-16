package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;
import java.net.*;
import java.sql.*;

import controller.JWT.*;
import controller.Users;

import java.security.MessageDigest;

public class Model
{    
	Statement stmt;               						
	ResultSet rs;	
	PreparedStatement statement;
	Connection con;
	String key = "nicekey";
		
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
	public Boolean addData(String login, String password)
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

		} catch (Exception e) { System.out.println("ERROR in class MODEL: " + e); return false; }
		return true;
	}

	public Boolean checkData(String login, String password) {
		try 
		{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, /*ResultSet.CONCUR_READ_ONLY,*/ ResultSet.CONCUR_UPDATABLE);  
			rs = stmt.executeQuery("SELECT * FROM users");

			while(rs.next())
			{
				if (rs.getString("login").equals(login) && rs.getString("password").equals(password))
					return true;
			}
		} catch (Exception e) { System.out.println("ERROR in class MODEL: " + e); return false; }
		return false;
	}

	public String generateToken(Users user){
		Header header;
		Payload payload;
		MessageDigest md;
		String header_encode;
		String payload_encode;
		String signature;
		String token = "NONE";

		try {
			header = new Header("HS256", "JWT");
			payload = new Payload(user.getLogin(), new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));

			header_encode = Base64.getEncoder().encodeToString((header.getAlg() + header.getTyp()).getBytes());
			payload_encode = Base64.getEncoder().encodeToString((payload.getName() + payload.getDate()).getBytes());
			// String header_payload_Base64Encode = Base64.getEncoder().encodeToString((header.getAlg() + header.getTyp() + payload.getName() + payload.getDate()).getBytes());
			// signature = new Signature(header_payload_Base64Encode);

			md = MessageDigest.getInstance("SHA-256");
			byte[] signatureBytes = md.digest((header_encode + payload_encode + key).getBytes()); 
			signature = Base64.getEncoder().encodeToString(signatureBytes);

			token = header_encode + "." + payload_encode + "." + signature;
			// addTokenToDB(token, user);
		} catch (Exception ex) { System.out.println("ERROR in generateToken in Model"); }

		return token;
	}

	public Boolean checkToken(String token){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");

			String[] tokenSplit = token.split("\\.");

			if((tokenSplit[2]).equals(Base64.getEncoder().encodeToString(md.digest((tokenSplit[0] + tokenSplit[1] + key).getBytes()))))
			{
				return true;
			}

		} catch (Exception ex) { System.out.println("ERROR in checkToken in Model" + ex); }
		return false;
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