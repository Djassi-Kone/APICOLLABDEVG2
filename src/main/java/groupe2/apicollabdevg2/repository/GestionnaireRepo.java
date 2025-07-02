package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionnaireRepo extends JpaRepository<Gestionnaire, Integer> {
    boolean existsGestionnaireByEmail(String email);



}