package me.nxs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Path("/proxy")
public class RestAggregator {

    @GET
    @Produces({"text/plain"})
    public String adder()
    {
        Client client = ClientBuilder.newClient();
        String response = client.target("http://localhost:8080/RecREST/ping").request().get().readEntity(String.class);
        return response+", Aniket";
    }
}
