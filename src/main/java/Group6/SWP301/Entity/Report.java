package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportid;
    @Column(name = "title")
    private String title;
    @Column(name = "evident")
    private String evident;
    @Column(name = "reportcontent")
    private String reportcontent;
    @Column(name = "datecreate")
    private Date date_create;
    @Column(name = "dateresolve")
    private Date date_resolve;

@Column(name = "reasondeny")
    private String reasondeny;
@Column(name = "status")
    private boolean status;

@ManyToOne
    @JoinColumn(name = "blogid")
    private Blogs blogid;

    @ManyToOne
    @JoinColumn(name = "commentid")
    private Comments commentid;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item itemid;


}
