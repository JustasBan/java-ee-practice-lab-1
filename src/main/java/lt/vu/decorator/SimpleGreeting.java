package lt.vu.decorator;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimpleGreeting implements IGreeting{

    @Override
    public String greet(String name) {
        return "Hello, " + name;
    }
}
