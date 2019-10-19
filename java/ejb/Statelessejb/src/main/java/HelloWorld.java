import javax.ejb.Stateless;

@Stateless
public class HelloWorld {
    public String sayHello(String name){
        return String.format("Hello %s",name);
    }
}
