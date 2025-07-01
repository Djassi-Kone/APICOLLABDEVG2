package groupe2.apicollabdevg2.controller;

import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.service.ContributeurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur REST pour gérer les opérations CRUD sur les contributeurs
@RestController
@RequestMapping("api") // Toutes les URLs commencent par /api
public class ContributeurController {

    // Service métier pour la gestion des contributeurs
    private final ContributeurService contributeurService;

    // Injection du service via le constructeur
    public ContributeurController(ContributeurService contributeurService) {
        this.contributeurService = contributeurService;
    }

    // Crée un nouveau contributeur
    @PostMapping("/contributeurs")
    @ResponseStatus(HttpStatus.CREATED) // Code 201 en cas de succès
    public Contributeur createContributeur(@RequestBody Contributeur contributeur) {
        // Délègue la création au service
        return contributeurService.creerContributeur(contributeur);
    }

    // Récupère tous les contributeurs existants
    @GetMapping("/contributeurs")
    public List<Contributeur> getAllContributeurs() {
        // Retourne la liste complète des contributeurs
        return contributeurService.listerContributeur();
    }

    // Récupère un contributeur spécifique par son ID
    @GetMapping("/contributeurs/{id}")
    public Contributeur getContributeurById(@PathVariable int id) {
        // Retourne le contributeur correspondant à l'ID
        return contributeurService.afficher(id);
    }

    // Met à jour les informations d'un contributeur existant
    @PutMapping("/contributeurs/{id}")
    public Contributeur updateContributeur(@PathVariable int id, @RequestBody Contributeur contributeur) {
        // Synchronise l'ID du chemin avec l'objet contributeur
        contributeur.setId(id);
        // Délègue la mise à jour au service
        return contributeurService.updateContributeur(contributeur);
    }

    // Supprime un contributeur existant
    @DeleteMapping("/contributeurs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Code 204 en cas de succès
    public void deleteContributeur(@PathVariable int id) {
        // Délègue la suppression au service
        contributeurService.supprimerContributeur(id);
    }
}