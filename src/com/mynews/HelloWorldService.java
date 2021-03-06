package com.mynews;


	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
	 
	@Path("/customers")
	public class HelloWorldService {
	 
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)

	  public Response getLocalCust(@QueryParam("query") String searchString) {
		  System.out.println("Request ===>>> " + searchString);
	           //return Response.status(200).entity(new Gson().toJson(InMemoryCache.getFeed(searchString))).build();
	           String json = new Gson().toJson(InMemoryCache.getFeed(searchString));
               
               if (json == null) {
            	   System.out.println("test");
            	   json = new Gson().toJson(InMemoryCache.getFeed(searchString));
            	   return Response.status(200).entity(json).build();
            	  
               }
               else {
            	   	return Response.status(200).entity(json).build();
               }
	  }
	 
	  @GET
	  @Path("/nri")
	  @Produces("text/html")
	  public Response getNriCust() {
	 
	            String output = "I am from 'getNriCust' method";
	            return Response.status(200).entity(output).build();
	  }
	}