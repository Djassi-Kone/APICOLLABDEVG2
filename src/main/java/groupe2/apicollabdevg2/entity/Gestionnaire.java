package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Gestionnaire")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String nom;
    @Column(unique = true)
    private String prenom;
    @Column(nullable = false, unique = true)
    private String email;

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
}
