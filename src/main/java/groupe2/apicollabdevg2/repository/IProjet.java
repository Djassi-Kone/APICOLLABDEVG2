package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProjet extends JpaRepository<Projet, String> {
    Optional<Projet> findById(int id);
}
