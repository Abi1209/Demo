package com.lti.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")

public class HelloService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello()
	{
		return "Plain text ...HELLO";
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello()
	{
		return "<hello> Welcome </hello>";
	}

	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public String sayHTMLHello()
	{
		return "<font-color=purple size=8> HELLO With HTML </font>";
	}




}



