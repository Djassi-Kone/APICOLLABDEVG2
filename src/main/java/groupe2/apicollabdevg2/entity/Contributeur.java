package groupe2.apicollabdevg2.entity;

import groupe2.apicollabdevg2.Enum.Nivau;
import groupe2.apicollabdevg2.Enum.Profil;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Contributeur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Contributeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = false)
    private String nom;

    @Column(unique = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Profil profil;

    @Enumerated(EnumType.STRING)
    private Nivau niveau;

    private boolean connected = false;

    @OneToMany(mappedBy = "contributeur")
    private List<IdeeProjet> ideeProjets;

    @OneToMany(mappedBy = "contributeur")
    private List<Badges> badges;

    @OneToMany(mappedBy = "contributeur")
    private List<Coins> coins;

    @OneToMany(mappedBy = "contributeur")
    private List<Contribution> contribution;

    @OneToMany(mappedBy = "contributeur")
    private List<DemandeParticipation> demandeParticipation;

    @OneToMany(mappedBy = "contributeur")
    private List<Fonctionnalites> fonctionnalites;

    // Constructeur par défaut
    public Contributeur() {
    }

    // Constructeur avec paramètres
    public Contributeur(String nom, String prenom, String email, String password, Profil profil, Nivau niveau) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.profil = profil;
        this.niveau = niveau;
        this.connected = false;
    }

    // Getters et setters
    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Nivau getNiveau() {
        return niveau;
    }

    public void setNiveau(Nivau niveau) {
        this.niveau = niveau;
    }

    // Getters pour les relations (optionnel selon vos besoins)
    public List<IdeeProjet> getIdeeProjets() {
        return ideeProjets;
    }

    public void setIdeeProjets(List<IdeeProjet> ideeProjets) {
        this.ideeProjets = ideeProjets;
    }

    // Ajoutez les autres getters/setters pour les relations si nécessaire
}