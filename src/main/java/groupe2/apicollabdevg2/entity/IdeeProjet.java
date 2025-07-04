package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "IdeeProjet")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class IdeeProjet {

    private String titre;
    private String description;
    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;
    // Méthode exécutée AVANT l'insertion en base
    @PrePersist
    public void prePersist() {
        this.dateCreation = LocalDate.now(); // Date système
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name="Contributeur_id",referencedColumnName = "id",nullable = false)
    private Contributeur contributeur;

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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contributeur getContributeur() {
        return contributeur;
    }

    public void setContributeur(Contributeur contributeur) {
        this.contributeur = contributeur;
    }
}
