package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "Contributeur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private Profil profil;
    @Enumerated(EnumType.STRING)
    private Nivau niveau;

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
}
