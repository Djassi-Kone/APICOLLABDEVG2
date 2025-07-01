package groupe2.apicollabdevg2.service;

import groupe2.apicollabdevg2.entity.Gestionnaire;
import groupe2.apicollabdevg2.repository.GestionnaireRepo;
import org.springframework.stereotype.Service;

import java.util.List;

// Service pour la gestion des opérations CRUD des gestionnaires
@Service
public class GestionnaireService {

    // Repository pour accéder à la base de données
    private final GestionnaireRepo gestionnaireRepo;

    // Injection du repository via le constructeur
    public GestionnaireService(GestionnaireRepo gestionnaireRepo) {
        this.gestionnaireRepo = gestionnaireRepo;
    }

    // Crée un nouveau gestionnaire après vérification de l'email
    public Gestionnaire create(Gestionnaire gestionnaire) {
        // Vérifie si l'email existe déjà
        if (gestionnaireRepo.existsGestionnaireByEmail(gestionnaire.getEmail())) {
            throw new RuntimeException("Email déjà utilisé par un autre gestionnaire");
        }
        // Sauvegarde le nouveau gestionnaire
        return gestionnaireRepo.save(gestionnaire);
    }

    // Récupère la liste complète des gestionnaires
    public List<Gestionnaire> getAll() {
        return gestionnaireRepo.findAll();
    }

    // Trouve un gestionnaire par son ID
    public Gestionnaire getById(int id) {
        // Retourne le gestionnaire ou lance une exception si non trouvé
        return gestionnaireRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Gestionnaire introuvable"));
    }

    // Met à jour les informations d'un gestionnaire existant
    public Gestionnaire update(Gestionnaire gestionnaire) {
        // Vérifie que le gestionnaire existe avant mise à jour
        if (!gestionnaireRepo.existsById(gestionnaire.getId())) {
            throw new RuntimeException("Gestionnaire introuvable");
        }
        // Effectue la mise à jour
        return gestionnaireRepo.save(gestionnaire);
    }

    // Supprime un gestionnaire par son ID
    public void delete(int id) {
        // Vérifie que le gestionnaire existe avant suppression
        if (!gestionnaireRepo.existsById(id)) {
            throw new RuntimeException("Gestionnaire introuvable");
        }
        // Supprime le gestionnaire
        gestionnaireRepo.deleteById(id);
    }
}