package groupe2.apicollabdevg2.service;

import groupe2.apicollabdevg2.DTO.ContributeurDTO;
import groupe2.apicollabdevg2.entity.Contributeur;
import groupe2.apicollabdevg2.repository.ContributeurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContributeurService {

    @Autowired
    private ContributeurRepo contributeurRepo;

    public Contributeur afficher(int id) {
        return contributeurRepo.findById(id).orElseThrow();
    }
// lister les contributeur
    public List<ContributeurDTO> listerContributeur() {
        List<ContributeurDTO> dtos = new ArrayList<>();
        List<Contributeur> contributeurs = contributeurRepo.findAll();

        for (Contributeur c : contributeurs) {
            ContributeurDTO dto = new ContributeurDTO();
            dto.setNom(c.getNom());
            dto.setPrenom(c.getPrenom());
            dto.setEmail(c.getEmail());
            dto.setProfil(c.getProfil());
            dto.setNiveau(c.getNiveau());
            dtos.add(dto);
        }
        return dtos;
    }
// mettre a jour les contributeur
    public Contributeur updateContributeur(Contributeur contributeur) {
        if (!contributeurRepo.existsById(contributeur.getId())) {
            throw new RuntimeException("Contributeur introuvable");
        }

        return contributeurRepo.save(contributeur);
    }

    // supression de contributeur
    public void supprimerContributeur(int id) {
        if (!contributeurRepo.existsById(id)) {
            throw new RuntimeException("Contributeur introuvable");
        }
        contributeurRepo.deleteById(id);
    }
//contributeur connecter
public Contributeur Contributeurconect(String email, String password) {
    Optional<Contributeur> optContributeur = contributeurRepo.findByEmail(email);
    if (optContributeur.isEmpty() || !optContributeur.get().getPassword().equals(password)) {
        throw new RuntimeException("Email ou mot de passe incorrect");
    }

    Contributeur contributeur = optContributeur.get();
    contributeur.setConnected(true);
    return contributeurRepo.save(contributeur);
}

    public void deconnecter(int id) {
        Contributeur contributeur = afficher(id);
        contributeur.setConnected(false);
        contributeurRepo.save(contributeur);

    }
// inscription du contributeur
    public Contributeur inscription(ContributeurDTO contributeurDTO) {
        if (contributeurRepo.existsByEmail(contributeurDTO.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        Contributeur contributeur = new Contributeur();
        contributeur.setEmail(contributeurDTO.getEmail());
        contributeur.setPassword(contributeurDTO.getPassword());
        contributeur.setNom(contributeurDTO.getNom());
        contributeur.setPrenom(contributeurDTO.getPrenom());
        contributeur.setNiveau(contributeurDTO.getNiveau());
        contributeur.setProfil(contributeurDTO.getProfil());

        return contributeurRepo.save(contributeur);
    }
    public Contributeur updateContributeur(int id, ContributeurDTO contributeurDTO) {
        Contributeur contributeur = afficher(id);

        contributeur.setNom(contributeurDTO.getNom());
        contributeur.setPrenom(contributeurDTO.getPrenom());
        contributeur.setEmail(contributeurDTO.getEmail());
        contributeur.setPassword(contributeurDTO.getPassword());
        contributeur.setProfil(contributeurDTO.getProfil());
        contributeur.setNiveau(contributeurDTO.getNiveau());

        return contributeurRepo.save(contributeur);
    }
}