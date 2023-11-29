package Group6.SWP301.Entity;

import javax.persistence.*;
@Entity
@Table(name = "pet_exchange")
public class PetExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petexchangeid;

    @ManyToOne
    @JoinColumn(name = "petid")
    private Pet petid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

    @Column(name = "petexchangetitle")
    private String title;
}
