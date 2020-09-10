package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// THis is how tell Spring to scan for different packages in different locations for components/services.
@ComponentScan(basePackages = {"guru.services", "guru.springframework"})
public class SfgDiApplication {

	public static void main(String[] args) {
		// testApp(args);

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		System.out.println(controller.sayHello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}



	/**
	 * This runs the old demo to test some of these dependencies.
	 * We're movingt his because JT's class is a little disorganised, and I don't want to lose this code.
	 * But basically what this does is build the context dynamically with a bunch of glorious
	 * .getBean and ApplicationContext stuff.
	 * @param args
	 */
	public static void testApp(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("----------I18n controller:");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());


		// Get a bean:
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("--------Primary bean: ");
		System.out.println(myController.sayHello());

		System.out.println("---------Property: Injected Controller:");
		/**
		 * One error can come from not having an @Controller annotation which marks the class as a
		 * Managed component - it won't be available in the context without the annotation.
		 */
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		// We can get rid of this line, since we annotated this bad boy as a Service.
		// propertyInjectedController.greetingService = new ConstructorGreetingService();

		System.out.println(propertyInjectedController.sayHello());

		System.out.println("----------Setter injected controller:");
		/**
		 * Another error that can occur, is that you need to autowire the setter function to get the right
		 * Greeting service injected.  There isn't much of a functional distinction between @Service and @Controller
		 */
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-----------Constructor injected controller:");
		/**
		 * With a constructor injected controller, you don't have to add an autowire function.
		 */
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());



	}

}
