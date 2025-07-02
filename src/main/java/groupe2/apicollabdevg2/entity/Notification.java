package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;

import javax.naming.Referenceable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Notification")
public class Notification {

    @Id
    private Integer id_notification;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "Contributeur_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Contributeur contributeur;
}
