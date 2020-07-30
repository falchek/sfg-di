package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

/**
 * English implementation
 */
@Service
public class ConstructorGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello from the Constructor";
    }
}
