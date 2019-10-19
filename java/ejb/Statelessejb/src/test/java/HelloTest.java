import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class HelloTest {
    @EJB
    private HelloWorld hello;

    @Deployment
    public static Archive<?> createTestArchive(){
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(HelloWorld.class);
    }

    @Test
    public void shouldSayHello() throws Exception{
        Assert.assertEquals(hello.sayHello("Anikt"),"Hello Aniket");
    }
}
