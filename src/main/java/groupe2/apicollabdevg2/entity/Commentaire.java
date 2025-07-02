package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commentaire;


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

    private String contenu;



}
