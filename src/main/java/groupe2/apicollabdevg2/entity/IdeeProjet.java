package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "IdeeProjet")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class IdeeProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name="Contributeur_id",referencedColumnName = "id",nullable = false)
    private Contributeur contributeur;
}
