package nxs.test;

@Stateless
public class HelloWorld{
    public String sayHello(String name){
        return String.format("Hi %s", name);
    }
}