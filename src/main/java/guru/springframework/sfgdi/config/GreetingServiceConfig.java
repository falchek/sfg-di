package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.GreetingService;
import guru.springframework.sfgdi.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

//@Configuration
public class GreetingServiceConfig {

    // TODO:  Add repo?
    @Bean
    GreetingServiceFactory greetingServiceFactory() {
        return new GreetingServiceFactory();
    }

    @Bean
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingSerice("en");

    }

    @Bean
    @Primary
    @Profile("es")
    GreetingService I18nSpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingSerice("es");
    }
}
