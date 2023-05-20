package lt.vu.usecases;

import lt.vu.decorator.IGreeting;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Greeting {
    @Inject
    private IGreeting greeting;

    public String greet() {
        return greeting.greet("John");
    }
}
