package groupe2.apicollabdevg2.controller;


import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.service.ContributeurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @noinspection ALL*/
@RestController
@RequestMapping("api")
public class ContributeurController {
    private final ContributeurService contributeurService;

    public ContributeurController(ContributeurService contributeurService) {
        this.contributeurService = contributeurService;
    }

    // Créer un contributeur (POST)
    @PostMapping("/contributeurs")
    @ResponseStatus(HttpStatus.CREATED) // Retourne 201 si succès
    public Contributeur createContributeur(@RequestBody Contributeur contributeur) {
        return contributeurService.creerContributeur(contributeur);
    }

    // Lister tous les contributeurs (GET)
    @GetMapping("/contributeurs")
    public List<Contributeur> getAllContributeurs() {
        return contributeurService.listerContributeur();
    }

    // Récupérer un contributeur par ID (GET)
    @GetMapping("/contributeurs/{id}")
    public Contributeur getContributeurById(@PathVariable int id) {
        return contributeurService.afficher(id);
    }

    // Mettre à jour un contributeur (PUT)
    @PutMapping("/contributeurs/{id}")
    public Contributeur updateContributeur(@PathVariable int id, @RequestBody Contributeur contributeur) {
        contributeur.setId(id); // Assure que l'ID est correct
        return contributeurService.updateContributeur(contributeur); // À implémenter dans le service
    }

    // Supprimer un contributeur (DELETE)
    @DeleteMapping("/contributeurs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retourne 204 si succès
    public void deleteContributeur(@PathVariable int id) {
        contributeurService.supprimerContributeur(id); // À implémenter dans le service
    }
}
