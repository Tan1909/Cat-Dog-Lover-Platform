package Group6.SWP301.Entity;

import javax.persistence.*;

@Entity
@Table(name = "item_exchange")
public class ItemExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemexchange_id;


    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item itemid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

    @Column(name = "itemexchangetitle")
    private String title;
}
