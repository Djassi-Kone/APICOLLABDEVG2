package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Coins")
@Getter
@Setter
@NoArgsConstructor

public class Coins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// generation de id de façcons auto
    private int id;

    @ManyToOne
    @JoinColumn(name="contributeur_id", referencedColumnName = "id", nullable = false)
    private Contributeur contributeur;

}
