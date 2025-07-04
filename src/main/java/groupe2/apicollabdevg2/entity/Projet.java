package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Projet")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="projet_id", nullable=false,referencedColumnName="id")
    private Gestionnaire gestionnaire;

    @OneToMany(mappedBy = "projet")

    private List<Contribution> contributions;
}
