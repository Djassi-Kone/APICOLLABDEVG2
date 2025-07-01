package groupe2.apicollabdevg2.service;

import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.repository.ContributeurRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContributeurService {
    private final ContributeurRepo contributeurRepo;

    public ContributeurService(ContributeurRepo contributeurRepo) {
        this.contributeurRepo = contributeurRepo;
    }

    public Contributeur afficher(int id) {
        return contributeurRepo.findById(id).orElseThrow();
    }

    public List<Contributeur> listerContributeur() {
        return contributeurRepo.findAll();
    }

    public Contributeur updateContributeur(Contributeur contributeur) {
        // Vérifie si le contributeur existe
        if (!contributeurRepo.existsById(contributeur.getId())) {
            throw new RuntimeException("Contributeur non trouvé avec l'id: " + contributeur.getId());
        }
        return contributeurRepo.save(contributeur);
    }

    public Contributeur creerContributeur(Contributeur contributeur) {
        // Vérifie si l'email existe déjà
        if (contributeurRepo.existsByEmail(contributeur.getEmail())) {
            throw new RuntimeException("Un contributeur avec cet email existe déjà");
            // Ou: return null; selon votre logique métier
        }

        // Sauvegarde et retourne le nouveau contributeur
        return contributeurRepo.save(contributeur);
    }

    public void supprimerContributeur(int id) {
        // Vérifie si le contributeur existe avant de supprimer
        if (!contributeurRepo.existsById(id)) {
            throw new RuntimeException("Contributeur non trouvé avec l'id: " + id);
        }
        contributeurRepo.deleteById(id);
    }
}
