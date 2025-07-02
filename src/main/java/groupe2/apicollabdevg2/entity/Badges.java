package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;

@Entity
@Table(name="badges")
public class Badges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name="contributeur_id", referencedColumnName = "id", nullable = false)
    private Contributeur contributeur;
}
