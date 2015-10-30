package console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsoleLauncher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsoleIO io = (ConsoleIO) context.getBean("consoleio");
        io.start();
    }
}