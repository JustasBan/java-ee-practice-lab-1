package lt.vu.decorator;

import lt.vu.decorator.IGreeting;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class GreetingDecorator implements IGreeting {

    @Inject
    @Delegate
    private IGreeting greeting;

    @Override
    public String greet(String name) {
        String originalGreeting = greeting.greet(name);
        return originalGreeting + " Have a nice day!";
    }
}
