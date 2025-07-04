package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Gestionnaire;
import groupe2.apicollabdevg2.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IGestionnaire extends JpaRepository<Gestionnaire, String> {
    Optional<Gestionnaire> findByNom(String nom);
    Optional<Gestionnaire> findByDescription(String description);

    List<Gestionnaire> nom(String nom);
}
