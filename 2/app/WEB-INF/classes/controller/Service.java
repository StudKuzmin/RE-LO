package controller;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import javax.inject.Inject;

import model.Model;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.net.*;
import java.sql.*;

import com.google.gson.*;

@Path("/")
public class Service {
	
	// @Inject
	// IModel model;
	
	@POST   
	@Path("/regData")
	@Consumes("application/json")
	@Produces("application/json")
	public Response regData(String userDataJSON) 
	{    
		Gson gson = new Gson();
		String resultJSON;
		Users user = null;
		Model model;

		try 
		{  
			model = new Model();
			try 
			{ 
				user = gson.fromJson(userDataJSON, Users.class);                   
			} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
			resultJSON = model.addData(user.getLogin(), user.getPassword());
			
		}
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }  

		return Response.ok(true).build(); 
	}

	@POST   
	@Path("/logData")
	@Consumes("application/json")
	@Produces("application/json")
	public Response logData(String userDataJSON) 
	{    
		Gson gson = new Gson();
		String resultJSON;
		Users user = null;
		Model model;

		try 
		{  
			model = new Model();
			try 
			{ 
				user = gson.fromJson(userDataJSON, Users.class);                   
			} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
			model.checkData(user.getLogin());
		}
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }  

		return Response.ok(true).build(); 
	}
}