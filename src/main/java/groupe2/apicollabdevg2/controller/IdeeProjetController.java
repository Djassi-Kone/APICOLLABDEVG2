package groupe2.apicollabdevg2.controller;

import groupe2.apicollabdevg2.DTO.ContributeurDTO;
import groupe2.apicollabdevg2.DTO.IdeeProjetDTO;
import groupe2.apicollabdevg2.service.IdeeProjetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idees")
public class IdeeProjetController {

    private final IdeeProjetService ideeProjetService;

    // Constructeur explicite pour l'injection
    public IdeeProjetController(IdeeProjetService ideeProjetService) {
        this.ideeProjetService = ideeProjetService;
    }

    @PostMapping
    public String creerIdee(@RequestBody IdeeProjetDTO dto) {
        ideeProjetService.creerIdee(dto);
        return "Idée créée avec succès";




    }
}