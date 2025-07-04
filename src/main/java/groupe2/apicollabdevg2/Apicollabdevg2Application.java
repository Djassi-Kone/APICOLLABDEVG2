package groupe2.apicollabdevg2;

import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.repository.IContributeur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Apicollabdevg2Application {

	public static void main(String[] args) {
		SpringApplication.run(Apicollabdevg2Application.class, args);
	}

	@Bean
	CommandLineRunner  AdminParDefaut(IContributeur iContributeur, PasswordEncoder passwordEncoder) {
		return args -> {

			String AdminNom = "admin";
			String AdminPassword = "admin123";

			if (iContributeur.findByNom(AdminNom).isEmpty()) {
				Contributeur admin = new Contributeur();

				admin.setNom(AdminNom);
				admin.setPassword(passwordEncoder.encode(AdminPassword));

				iContributeur.save(admin);

				System.out.println("Admin creer avec succès ");


			} else {

				System.out.println("Admin deja existant "+AdminNom+"Mot de passe "+AdminPassword);

			}

		};

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
