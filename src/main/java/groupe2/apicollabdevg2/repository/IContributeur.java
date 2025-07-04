package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.entity.Gestionnaire;
import groupe2.apicollabdevg2.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IContributeur extends JpaRepository<Contributeur, String> {
    Optional<Contributeur> findByNom(String nom);
    Optional<Contributeur> findByDescription(String description);

}
