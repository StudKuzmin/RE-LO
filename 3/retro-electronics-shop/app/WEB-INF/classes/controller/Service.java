package controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import javax.inject.Inject;

import model.Model;
import controller.JWT.*;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.net.*;
import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
		Boolean data_added;

		try 
		{  
			model = new Model();
			try 
			{ 
				user = gson.fromJson(userDataJSON, Users.class);                   
			} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
			// Данные успешно добавлены
			data_added = model.addData(user.getLogin(), user.getPassword());
			if (data_added)
				return Response.ok(true).build(); 
		}
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); } 

		return Response.ok(false).build(); 
	}



	@POST   
	@Path("/logData")
	@Consumes("application/json")
	@Produces("application/json")
	public Response logData(@HeaderParam("Authentication") String st, String userDataJSON) 
	{    
		Gson gson = new Gson();
		String resultJSON;
		Users user = null;
		Model model;
		Boolean data_is_ok;
		Header header;
		Payload payload;
		Signature signature;

		try 
		{  
			model = new Model();
			try 
			{ 
				user = gson.fromJson(userDataJSON, Users.class);                   
			} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			


			// Данные совпали
			data_is_ok = model.checkData(user.getLogin(), user.getPassword());
			if (data_is_ok) {
				header = new Header("HS256", "JWT");
				payload = new Payload(user.getLogin(), new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));

				String header_encode = Base64.getEncoder().encodeToString((header.getAlg() + header.getTyp()).getBytes());
				String payload_encode = Base64.getEncoder().encodeToString((payload.getName() + payload.getDate()).getBytes());
				String header_payload_Base64Encode = Base64.getEncoder().encodeToString((header.getAlg() + header.getTyp() + payload.getName() + payload.getDate()).getBytes());
				// signature = new Signature(header_payload_Base64Encode);

				String token = header_encode + "." + payload_encode + "." + header_payload_Base64Encode;

				return Response.ok(st).build(); 
			}
			return Response.ok(false).build(); 
		}
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }  
	}

	@GET   
	@Path("/getSearchResult")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getSearchResult() 
	{    
		Gson gson = new Gson();
		String resultJSON;
		Users user = null;
		Model model;
		Boolean data_added;

		try 
		{  
			// model = new Model();
			// try 
			// { 
			// 	user = gson.fromJson(userDataJSON, Users.class);                   
			// } catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
			// // Данные успешно добавлены
			// data_added = model.addData(user.getLogin(), user.getPassword());
			// if (data_added)
			// 	return Response.ok(true).build(); 
		}
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); } 
		 
		return Response.ok(false).build(); 
	}
}