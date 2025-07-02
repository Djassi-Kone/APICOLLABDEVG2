package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DebloquerProjet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DebloquerProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Boolean visibilite;
    private int nombredecoins;

    @ManyToOne
    @JoinColumn(name = "Contributeur_id")
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "Projet_id")
    private Projet projet;
}
