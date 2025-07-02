package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Contribution")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="contributeur_id", referencedColumnName = "id", nullable = false)
    private Contributeur contributeur;

}
