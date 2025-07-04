package groupe2.apicollabdevg2.service;

import groupe2.apicollabdevg2.DTO.IdeeProjetDTO;
import groupe2.apicollabdevg2.entity.IdeeProjet;
import groupe2.apicollabdevg2.repository.ContributeurRepo;
import groupe2.apicollabdevg2.repository.IdeeProjetRepo;
import org.springframework.stereotype.Service;

@Service
public class IdeeProjetService {

    private final IdeeProjetRepo ideeProjetRepo;
    private final ContributeurRepo contributeurRepo;

    public IdeeProjetService(IdeeProjetRepo ideeProjetRepo, ContributeurRepo contributeurRepo) {
        this.ideeProjetRepo = ideeProjetRepo;
        this.contributeurRepo = contributeurRepo;
    }

    public IdeeProjet creerIdee(IdeeProjetDTO ideeDTO) {
        IdeeProjet idee = new IdeeProjet();
        idee.setTitre(ideeDTO.getTitre());
        idee.setDescription(ideeDTO.getDescription());
        idee.setContributeur(contributeurRepo.getById(ideeDTO.getContributeurId()));
        return ideeProjetRepo.save(idee);
    }
}