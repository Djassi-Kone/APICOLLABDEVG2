package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Gestionnaire")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Gestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
}
