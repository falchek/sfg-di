package guru.springframework.sfgdi.controllers;

import guru.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * DI using the setter.  Super gross but not so bad as properties
 */
class SetterInjectedControllerTest {

    SetterInjectedController controller;


    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}