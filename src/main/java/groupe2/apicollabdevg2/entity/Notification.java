package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Referenceable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Notification")
@Data
public class Notification {

    @Id
    private Integer id_notification;

    @Column
    private String description;

    @Column
    private String envoyeur;


    @Enumerated(EnumType.STRING)
    private Type type;




    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "Contributeur_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Contributeur contributeur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "Projet_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Projet projet;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "Gestionnaire_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Gestionnaire gestionnaire;

    public Integer getId_notification() {
        return id_notification;
    }

    public void setId_notification(Integer id_notification) {
        this.id_notification = id_notification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Contributeur getContributeur() {
        return contributeur;
    }

    public void setContributeur(Contributeur contributeur) {
        this.contributeur = contributeur;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
