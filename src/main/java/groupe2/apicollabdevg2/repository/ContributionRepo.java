package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContributionRepo extends JpaRepository<Contribution, Integer> {
    List<Contribution> findByProjetId(int projetId);
}
