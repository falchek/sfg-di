package guru.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Showcases primary bean
 */
@Service
@Primary
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello from primary annotation type injection.";
    }
}
