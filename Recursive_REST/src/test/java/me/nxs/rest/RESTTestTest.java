package me.nxs.rest;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.net.URL;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class RESTTestTest {

    @ArquillianResource
    private URL webappURL;

    WebTarget webTarget;
    WebTarget pingTarget;
    WebTarget proxyTarget;

    @Before
    public void before() throws Exception{
        webTarget = ClientBuilder.newClient().target(webappURL.toURI());
        pingTarget = webTarget.path("ping");
        proxyTarget = webTarget.path("proxy");
    }

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "RecREST.war")
                .addClass(RESTTest.class)
                .addClass(RestAggregator.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Test
    @InSequence(1)
    public void checkPing(){
        Response response =  pingTarget
                .request()
                .get();
        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());
        assertEquals("Hello World!!",response.readEntity(String.class));

    }

    @Test
    @InSequence(2)
    public void checkPingMessage(){
        Response pingResponse = pingTarget.request().get();
        Response proxyResponse = proxyTarget.request().get();
        assertEquals(Response.Status.OK.getStatusCode(),proxyResponse.getStatus());
        assertNotEquals(pingResponse,proxyResponse);
        assertNotEquals(pingResponse.readEntity(String.class),proxyResponse.readEntity(String.class));
        assertEquals(pingResponse.readEntity(String.class).concat(", Aniket"),proxyResponse.readEntity(String.class));

    }


}
