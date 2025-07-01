package groupe2.apicollabdevg2.controller;

import groupe2.apicollabdevg2.entity.Gestionnaire;
import groupe2.apicollabdevg2.service.GestionnaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur REST pour la gestion des opérations CRUD sur les gestionnaires
@RestController
@RequestMapping("api") // Toutes les URLs commencent par /api
public class GestionnaireController {

    // Service métier injecté pour la gestion des gestionnaires
    private final GestionnaireService gestionnaireService;

    // Injection du service via le constructeur
    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    // Crée un nouveau gestionnaire
    @PostMapping("/gestionnaires")
    public Gestionnaire createGestionnaire(@RequestBody Gestionnaire gestionnaire) {
        // Délègue la création au service métier
        return gestionnaireService.create(gestionnaire);
    }

    // Récupère tous les gestionnaires existants
    @GetMapping("/gestionnaires")
    public List<Gestionnaire> getAllGestionnaires() {
        // Retourne la liste complète des gestionnaires
        return gestionnaireService.getAll();
    }

    // Récupère un gestionnaire spécifique par son ID
    @GetMapping("/gestionnaires/{id}")
    public Gestionnaire getGestionnaireById(@PathVariable int id) {
        // Retourne le gestionnaire correspondant à l'ID
        return gestionnaireService.getById(id);
    }

    // Met à jour un gestionnaire existant
    @PutMapping("/gestionnaires/{id}")
    public Gestionnaire updateGestionnaire(@PathVariable int id, @RequestBody Gestionnaire gestionnaire) {
        // Synchronise l'ID du chemin avec l'objet gestionnaire
        gestionnaire.setId(id);
        // Délègue la mise à jour au service métier
        return gestionnaireService.update(gestionnaire);
    }

    // Supprime un gestionnaire existant
    @DeleteMapping("/gestionnaires/{id}")
    public void deleteGestionnaire(@PathVariable int id) {
        // Délègue la suppression au service métier
        gestionnaireService.delete(id);
    }
}