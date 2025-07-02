package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Contributeur")
@Getter
@Setter
//@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Contributeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// generation de id de façcons auto
    private int id;
    @Column(unique = true)
    private String nom;
    @Column(unique = true) // les donner de cette colone sont unique pas de doublon
    private String prenom;
    @Column(nullable = false, unique = true) // Email obligatoire et unique
    private String email;
    @Column(nullable = false, unique = true) // Email obligatoire et unique
    private String password;
    @Enumerated(EnumType.STRING)
    private Profil profil;
    @Enumerated(EnumType.STRING)
    private Nivau niveau;

    public Contributeur( String nom, String prenom, String email, Profil profil, Nivau niveau) {
        //this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.profil = profil;
        this.niveau = niveau;
    }

    public Contributeur(){}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
