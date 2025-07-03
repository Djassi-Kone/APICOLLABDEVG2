package groupe2.apicollabdevg2.controller;

import groupe2.apicollabdevg2.DTO.AuthDTO;
import groupe2.apicollabdevg2.DTO.ContributeurDTO;
import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.service.ContributeurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ContributeurController {

    private final ContributeurService contributeurService;

    public ContributeurController(ContributeurService contributeurService) {
        this.contributeurService = contributeurService;
    }

    @PostMapping("/contributeurs")
    @ResponseStatus(HttpStatus.CREATED)
    public Contributeur creerContributeur(@RequestBody ContributeurDTO contributeurDTO) {
        return contributeurService.inscription(contributeurDTO);
    }

    @GetMapping("/contributeurs")
    public List<ContributeurDTO> getAllContributeurs() {
        return contributeurService.listerContributeur();
    }

    @GetMapping("/contributeurs/{id}")
    public Contributeur getContributeurById(@PathVariable int id) {
        return contributeurService.afficher(id);
    }

    @PutMapping("/contributeurs/{id}")
    public Contributeur updateContributeur(@PathVariable int id, @RequestBody ContributeurDTO contributeurDTO) {
        Contributeur contributeur = contributeurService.afficher(id);
        contributeur.setNom(contributeurDTO.getNom());
        contributeur.setPrenom(contributeurDTO.getPrenom());
        contributeur.setEmail(contributeurDTO.getEmail());
        contributeur.setPassword(contributeurDTO.getPassword());
        contributeur.setProfil(contributeurDTO.getProfil());
        contributeur.setNiveau(contributeurDTO.getNiveau());
        return contributeurService.updateContributeur(contributeur);
    }

    @DeleteMapping("/contributeurs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimerContributeur(@PathVariable int id) {
        contributeurService.supprimerContributeur(id);
    }
    @PostMapping("/contributeurs/{id}/connexion")
    public Contributeur connecter(@RequestBody AuthDTO authDTO) {
        return contributeurService.Contributeurconect(authDTO.getEmail(), authDTO.getPassword());
    }

    @PostMapping("/contributeurs/{id}/deconnexion")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deconnecter(@PathVariable int id) {
        contributeurService.deconnecter(id);
    }
}