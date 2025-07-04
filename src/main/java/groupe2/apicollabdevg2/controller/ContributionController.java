package groupe2.apicollabdevg2.controller;

import groupe2.apicollabdevg2.DTO.ContributionDTO;
import groupe2.apicollabdevg2.entity.Contribution;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContributionController {
    @PostMapping("/projets/{projetId}/contributions")
    public Contribution contribuer(
            @PathVariable int projetId,
            @RequestBody ContributionDTO contributionDTO
    ) {
        // Implémentez la logique ici
        return null;
    }
}
