package guru.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello() {
        String testString = "Hello, superchiefs and chieftains";
        System.out.println(testString);

        return testString;
    }





}
