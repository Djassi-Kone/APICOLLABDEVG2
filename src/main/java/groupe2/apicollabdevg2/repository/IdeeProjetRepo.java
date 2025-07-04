package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.IdeeProjet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdeeProjetRepo extends JpaRepository<IdeeProjet, Integer> {
    List<IdeeProjet> findByContributeurId(int contributeurId);
}
