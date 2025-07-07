package groupe2.apicollabdevg2.entity;


import groupe2.apicollabdevg2.Enum.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Contribution")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {

    private int nbrCoins;
    private LocalDate dateContribution;
    private String contenu;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="contributeur_id", referencedColumnName = "id", nullable = false)
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name="projet_id", referencedColumnName = "id", nullable = false)
    private Projet projet;



}
