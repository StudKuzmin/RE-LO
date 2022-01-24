package controller;

import javax.ws.rs.Path;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import javax.ws.rs.core.Response;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;

import javax.inject.Inject;

import model.Model;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.net.*;
import java.sql.*;





@Path("/")
public class Service {
	
	// @Inject
	// IModel model;

	// @POST   
	// @Path("/app")
	// @Consumes("application/json")
	// @Produces("application/json")
	// public Response userData() 
	// {            
	// 	Jsonb jsonb = JsonbBuilder.create();          
	// 	List<StudentData> studentsData;      
	// 	String resultJSON;
	// 	try 
	// 	{  
	// 		return Response.ok("ANSWER IS OK").build();
			 
	// 	}
	// 	catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
	// }
	
	// @POST   
	// @Path("/changeArray")
	// @Consumes("application/json")
	// @Produces("application/json")
	// public Response changeArray(String userDataJSON) 
	// {    
		
	// 	Jsonb jsonb = JsonbBuilder.create();          
	// 	List<Student> students;      
	// 	String resultJSON;
	// 	try 
	// 	{  
	// 		try 
	// 		{ 
	// 			students = jsonb.fromJson(userDataJSON, new ArrayList<Student>(){}.getClass().getGenericSuperclass());  
				
	// 		} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
	// 		model.changeTable(students);
	// 		resultJSON = jsonb.toJson(students);
			
	// 	}
	// 	catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
	// 	catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
	// 	return Response.ok(true).build();
	// }
	
	
	// @POST
	// @Path("/showArray")
	// @Consumes("application/json")
	// @Produces("application/json")
	// public Response showArray() 
	// {            
	// 	Jsonb jsonb = JsonbBuilder.create();          
	// 	List<Student> students;      
	// 	String resultJSON;
	// 	try 
	// 	{  
	// 		students = new ArrayList<>();
			
	// 		model.fillTable(students);
	// 		resultJSON = jsonb.toJson(students);
	// 	}	
	// 	catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
	// 	catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
		
	// 	return Response.ok(resultJSON).build();    
	// }
	
	// @POST   
	// @Path("/userData")
	// @Consumes("application/json")
	// @Produces("application/json")
	// public Response userData(String userDataJSON) 
	// {            
	// 	Jsonb jsonb = JsonbBuilder.create();          
	// 	List<StudentData> studentsData;      
	// 	String resultJSON;
	// 	try 
	// 	{  
	// 		try 
	// 		{ 
	// 			studentsData = jsonb.fromJson(userDataJSON, new ArrayList<StudentData>(){}.getClass().getGenericSuperclass());                    
	// 		} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
	// 		if(model.checkUserData(studentsData))
	// 			return Response.ok(true).build();
	// 		return Response.ok(false).build();
			 
	// 	}
	// 	catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
	// 	catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
	// }
 

 
}