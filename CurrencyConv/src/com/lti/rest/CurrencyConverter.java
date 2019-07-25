package com.lti.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("/currency")
public class CurrencyConverter {
@GET
@Path("/{rs}")
@Produces(MediaType. TEXT_HTML)
public String rsToDollar(@PathParam("rs")double rs)
{
	double d = rs*0.75;
	return "<h1>" +rs+ " /-Rs. , Dollar="+d+"</h1>";
}
}
