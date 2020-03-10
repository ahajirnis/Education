package me.nxs.rest;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
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

    @Before
    public void before() throws Exception{
//        webTarget = ClientBuilder.newClient().target(webappURL.toURI()).path("RecREST");
        System.out.println(webappURL.getHost()+webappURL.getPort());
        webTarget = ClientBuilder.newClient().target(webappURL.toURI());
    }
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(RESTTest.class)
                .addClass(RestAggregator.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Test
    @InSequence(1)
    @RunAsClient
    public void checkPingStatus() throws Exception{
        final Response response =  webTarget
                .path("ping")
                .request()
                .get();

        assertEquals(Response.Status.OK.getStatusCode(),response.getStatus());

    }

}
