package me.nxs.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ping")
public class RESTTest
{
    @GET
    @Produces("text/plain")
    public String ping()
    {
        return "Hello World!!";
    }

}
