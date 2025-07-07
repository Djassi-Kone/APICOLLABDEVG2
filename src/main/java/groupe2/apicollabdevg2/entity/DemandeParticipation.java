package groupe2.apicollabdevg2.entity;

import groupe2.apicollabdevg2.Enum.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DemandeParticipation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// generation de id de façcons auto
    private int id;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private String description;

    @ManyToOne
    @JoinColumn(name = "Contributeur_id")
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "Projer_id")
    private Projet projet;
}
