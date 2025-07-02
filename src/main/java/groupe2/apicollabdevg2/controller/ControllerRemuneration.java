package groupe2.apicollabdevg2.controller;

import groupe2.apicollabdevg2.entity.Badge;
import groupe2.apicollabdevg2.entity.Coin;
import groupe2.apicollabdevg2.entity.Utilisateur;
import groupe2.apicollabdevg2.repository.UtilisateurRepository;
import groupe2.apicollabdevg2.service.serviceRemunreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/rewards")
public class ControllerRemuneration {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private serviceRemunreation remuneration;

    //  Obtenir tous les badges
    @GetMapping("/badges")
    public List<Badge> getAllBadges() {
        return remuneration.getAllBadges();
    }

    //  Obtenir les coins d’un utilisateur par son ID
    @GetMapping("/coins/{utilisateurId}")
    public ResponseEntity<Coin> getUserCoins(@PathVariable Long utilisateurId) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(utilisateurId);

        if (utilisateurOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return remuneration.getUserCoins(utilisateurOpt.get())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  Assigner des coins à un utilisateur
    @PostMapping("/assign")
    public ResponseEntity<String> assignReward(@RequestBody Map<String, Object> payload) {
        try {
            Long utilisateurId = Long.valueOf(payload.get("utilisateurId").toString());
            int point = Integer.parseInt(payload.get("point").toString());

            Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(utilisateurId);
            if (utilisateurOpt.isEmpty()) {
                return ResponseEntity.status(404).body("Utilisateur non trouvé.");
            }

            remuneration.assigneCoin(utilisateurOpt.get(), point);
            return ResponseEntity.ok("Récompense attribuée avec succès !");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Données invalides : " + e.getMessage());
        }
    }
}
