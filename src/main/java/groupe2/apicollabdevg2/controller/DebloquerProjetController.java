package groupe2.apicollabdevg2.controller;


import groupe2.apicollabdevg2.DTO.DebloquerProjetDTO;
import groupe2.apicollabdevg2.entity.DebloquerProjet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebloquerProjetController {
    @PostMapping("/projets/{projetId}/debloquer")
    public DebloquerProjet debloquerProjet(
            @PathVariable int projetId,
            @RequestBody DebloquerProjetDTO dto
    ) {
        // Implémentez la logique ici
        return null;
    }
}
