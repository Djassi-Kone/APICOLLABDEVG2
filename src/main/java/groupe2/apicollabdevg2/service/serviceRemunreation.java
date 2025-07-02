package groupe2.apicollabdevg2.service;

import groupe2.apicollabdevg2.entity.Badge;
import groupe2.apicollabdevg2.entity.Coin;
import groupe2.apicollabdevg2.entity.Utilisateur;
import groupe2.apicollabdevg2.repository.CoinRepository;
import groupe2.apicollabdevg2.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceRemunreation {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private BadgeRepository badgeRepository; // Si tu gères les badges aussi

    // Ajouter un coin à un utilisateur
    public void assigneCoin(Utilisateur utilisateur, int point) {
        Coin coin = new Coin();
        coin.setCoinName("Récompense");
        coin.setNombre(point);
        coin.setUtilisateur(utilisateur);

        coinRepository.save(coin);
    }

    // Récupérer les coins d’un utilisateur
    public Optional<Coin> getUserCoins(Utilisateur utilisateur) {
        return coinRepository.findByUtilisateur(utilisateur);
    }

    // Liste des badges
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }
}
