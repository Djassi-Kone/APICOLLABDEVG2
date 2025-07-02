package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;



@Entity
@Table(name = "Badge")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Badge {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private int point;

    public String getNom() {
        return nom;
    }
}
