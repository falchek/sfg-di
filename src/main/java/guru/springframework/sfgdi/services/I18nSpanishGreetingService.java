package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Note - the qualifier for this service has the same name as the English Controller
 */
@Service("i18nService")
@Profile({"ES", "default"})
public class I18nSpanishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hola Mundo -- ES";
    }
}
