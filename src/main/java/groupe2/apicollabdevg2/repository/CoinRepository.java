package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Coin;
import groupe2.apicollabdevg2.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinRepository extends JpaRepository<Coin, Long> {
    Optional<Coin> findByUtilisateur(Utilisateur utilisateur);
}

