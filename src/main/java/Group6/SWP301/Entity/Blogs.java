package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blogs")
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogid;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "blogcontent")
    private String blogcontent;
    @Column(name = "datecreate")
    private Date datecreate;
    @Column(name = "dateupdate")
    private Date dateupdate;
    @Column(name = "status")
    private boolean status;
    @Column(name = "reasondeny")
    private String reasondeny;
    @Column(name = "react")
    private String react;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

    @ManyToOne
    @JoinColumn(name = "Blogcategoryid")
    private BlogCategory blogcategoryid;

    @OneToMany(mappedBy = "blogid")
    List<Report> listReport;
    @Override
    public String toString() {
        return "Blogs{" +
                "blogid=" + blogid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", blogcontent='" + blogcontent + '\'' +
                ", datecreate=" + datecreate +
                ", dateupdate=" + dateupdate +
                ", status=" + status +
                ", reasondeny='" + reasondeny + '\'' +
                ", react='" + react + '\'' +
                ", userid=" + userid +
                ", blogcategoryid=" + blogcategoryid +
                '}';
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlogcontent() {
        return blogcontent;
    }

    public void setBlogcontent(String blogcontent) {
        this.blogcontent = blogcontent;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getDateupdate() {
        return dateupdate;
    }

    public void setDateupdate(Date dateupdate) {
        this.dateupdate = dateupdate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReasondeny() {
        return reasondeny;
    }

    public void setReasondeny(String reasondeny) {
        this.reasondeny = reasondeny;
    }

    public String getReact() {
        return react;
    }

    public void setReact(String react) {
        this.react = react;
    }

    public UserAccount getUserid() {
        return userid;
    }

    public void setUserid(UserAccount userid) {
        this.userid = userid;
    }

    public BlogCategory getBlogcategoryid() {
        return blogcategoryid;
    }

    public void setBlogcategoryid(BlogCategory blogcategoryid) {
        this.blogcategoryid = blogcategoryid;
    }

}
