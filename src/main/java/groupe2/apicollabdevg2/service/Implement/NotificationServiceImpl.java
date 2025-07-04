package groupe2.apicollabdevg2.service.Implement;

import groupe2.apicollabdevg2.entity.*;
import groupe2.apicollabdevg2.repository.IContributeur;
import groupe2.apicollabdevg2.repository.IGestionnaire;
import groupe2.apicollabdevg2.repository.INotification;
import groupe2.apicollabdevg2.repository.IProjet;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Service;



@Service
public class NotificationServiceImpl {

    @Autowired
    INotification notification;

    @Autowired
    IContributeur contributeur;

    @Autowired
    IGestionnaire gestionnaire;

    @Autowired
    IProjet projet1;



    @Transactional
    public void validerContribution(int projetId, String nomGestionnaire, String nomContributeur,
                                    String description, Type typeNotification) {
        // Vérification de l'existence des entités
        Gestionnaire gest = gestionnaire.findByNom(nomGestionnaire)
                .orElseThrow(() -> new RuntimeException("Gestionnaire non trouvé"));

        Contributeur contrib = contributeur.findByNom(nomContributeur)
                .orElseThrow(() -> new RuntimeException("Contributeur non trouvé"));

        Projet projet = projet1.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé"));

        // Création d'une notification (si tu as une entité Notification)
        Notification notification = new Notification();
        notification.setType(typeNotification);
        notification.setDescription(description);
        notification.setProjet(projet);
        notification.setContributeur(contrib);
        notification.setGestionnaire(gest);
        INotification.save(notification);

        // Par exemple : marquer la contribution comme "validée"
        Contribution contribution = contributionRepository
                .findByProjetAndContributeur(projet, contrib)
                .orElseThrow(() -> new RuntimeException("Contribution non trouvée"));

        contribution.setValidee(true);
        contributionRepository.save(contribution);

        System.out.println("✅ Contribution validée avec succès.");
    }


}
