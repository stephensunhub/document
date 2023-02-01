package clue.document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "clue.document")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
