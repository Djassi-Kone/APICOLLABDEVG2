package groupe2.apicollabdevg2.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Contributeur")
public class Contributeur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    private String email;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @Enumerated(EnumType.STRING)
    private Profil profil;

    @OneToMany(mappedBy = "contributeur")
    private List<Notification> notification = new ArrayList<Notification>();
}
