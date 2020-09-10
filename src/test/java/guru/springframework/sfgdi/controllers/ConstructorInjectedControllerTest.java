package guru.springframework.sfgdi.controllers;

import guru.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Preferred DI method.
 */
class ConstructorInjectedControllerTest {


    ConstructorInjectedController controller;

    @BeforeEach
    void setup() {
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());

    }
}