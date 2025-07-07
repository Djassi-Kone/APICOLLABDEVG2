package groupe2.apicollabdevg2.repository;

import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.Enum.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContributeurRepo extends JpaRepository<Contributeur, Integer> {
    boolean existsByEmail(String email);
    boolean existsByPassword(String password);
    // Recherche par email
        Optional<Contributeur> findByEmail(String email);

        //Recherche par mot de passe
        Optional<Contributeur> findByPassword(String password);

        // Recherche par nom (ignore la casse)
        List<Contributeur> findByNomIgnoreCase(String nom);

        // Recherche par profil
        List<Contributeur> findByProfil(Profil profil);
    }
