package groupe2.apicollabdevg2.entity;

import groupe2.apicollabdevg2.Enum.Nivau;
import groupe2.apicollabdevg2.Enum.Profil;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Gestionnaire")
@Getter
@Setter
//@NoArgsConstructor
@ToString
public class Gestionnaire extends Contributeur {

    @OneToMany(mappedBy = "Fonctionalites")
    private List<Fonctionnalites> fonctionnalites;


    @OneToMany(mappedBy = "gestionnaire")
    private List<Projet> projet;

    public Gestionnaire(String nom, String prenom, String email, String password, Profil profil, Nivau niveau) {
        super(nom, prenom, email, password, profil, niveau);
    }

    public Gestionnaire() {}




}
