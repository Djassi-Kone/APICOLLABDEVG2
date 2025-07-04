package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Projet")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String description;
    private boolean cahierDesCharges;
    private Statut statut;
    private Niveau niveau;
    private int coin;
    private String historique;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projet")
    private List<Notification> notifications;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCahierDesCharges() {
        return cahierDesCharges;
    }

    public void setCahierDesCharges(boolean cahierDesCharges) {
        this.cahierDesCharges = cahierDesCharges;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }
}
