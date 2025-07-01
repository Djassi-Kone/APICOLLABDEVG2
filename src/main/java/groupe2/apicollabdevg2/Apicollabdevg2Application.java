package groupe2.apicollabdevg2;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})//desactivation de spring securité
public class Apicollabdevg2Application {

	public static void main(String[] args) {
		SpringApplication.run(Apicollabdevg2Application.class, args);
	}


	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			return;
		};
	}

}
