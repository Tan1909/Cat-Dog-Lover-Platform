package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "title")
    private String title;
@Column(name = "date_create")
    private Date date_create;
@Column(name = "detail")
    private String detail;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

}
