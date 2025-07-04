package groupe2.apicollabdevg2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  int nbrCoin;

    @Column
    private Date date;

    @Enumerated(EnumType.STRING)
    private Type statusType;

    @Column
    private boolean validee;
}
