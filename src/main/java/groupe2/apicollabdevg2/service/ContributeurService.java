package groupe2.apicollabdevg2.service;

import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.repository.ContributeurRepo;
import org.springframework.stereotype.Service;

import java.util.List;

// Service pour la gestion des opérations CRUD des contributeurs
@Service
public class ContributeurService {

    // Accès à la base de données via le repository
    private final ContributeurRepo contributeurRepo;

    // Injection du repository via le constructeur
    public ContributeurService(ContributeurRepo contributeurRepo) {
        this.contributeurRepo = contributeurRepo;
    }

    // Récupère un contributeur par son ID
    public Contributeur afficher(int id) {
        // Retourne le contributeur ou lance une exception si non trouvé
        return contributeurRepo.findById(id).orElseThrow();
    }

    // Retourne la liste de tous les contributeurs
    public List<Contributeur> listerContributeur() {
        return contributeurRepo.findAll();
    }

    // Met à jour un contributeur existant
    public Contributeur updateContributeur(Contributeur contributeur) {
        // Vérifie que le contributeur existe avant mise à jour
        if (!contributeurRepo.existsById(contributeur.getId())) {
            throw new RuntimeException("Contributeur introuvable");
        }
        return contributeurRepo.save(contributeur);
    }

    // Crée un nouveau contributeur
    public Contributeur creerContributeur(Contributeur contributeur) {
        // Vérifie que l'email n'existe pas déjà
        if (contributeurRepo.existsByEmail(contributeur.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }
        return contributeurRepo.save(contributeur);
    }

    // Supprime un contributeur par son ID
    public void supprimerContributeur(int id) {
        // Vérifie que le contributeur existe avant suppression
        if (!contributeurRepo.existsById(id)) {
            throw new RuntimeException("Contributeur introuvable");
        }
        contributeurRepo.deleteById(id);
    }
}