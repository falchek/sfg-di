package guru.springframework.sfgdi.services;

public class GreetingServiceFactory {


    // TODO:  Add this?
//    private GreetingRepository greetingRepository;

    public GreetingServiceFactory() {
//        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingSerice(String lang) {
        switch(lang){
            case "en":
                return new PrimaryGreetingService();
            case "es":
                return new I18nSpanishGreetingService();
            default:
                return new PrimaryGreetingService();
        }
    }
}
