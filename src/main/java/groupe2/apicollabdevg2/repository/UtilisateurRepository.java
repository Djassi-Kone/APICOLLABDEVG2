package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByEmail(String email);


}
