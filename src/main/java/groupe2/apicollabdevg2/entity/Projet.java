package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;

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

}
