package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentid;
    @Column(name = "datecreate")
    private Date datecreate;
    @Column(name = "dateupdate")
    private Date dateupdate;
    @Column(name = "commentcontent")
    private String commentcontent;
    @Column(name = "status")
    private int status;
    @Column(name = "reasonhiden")
    private String reasonhidden;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

    @OneToMany(mappedBy = "commentid")
    private List<Report> listReport;

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
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

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReasonhidden() {
        return reasonhidden;
    }

    public void setReasonhidden(String reasonhidden) {
        this.reasonhidden = reasonhidden;
    }

    public UserAccount getUserid() {
        return userid;
    }

    public void setUserid(UserAccount userid) {
        this.userid = userid;
    }

    public List<Replies> getListReplies() {
        return listReplies;
    }

    public void setListReplies(List<Replies> listReplies) {
        this.listReplies = listReplies;
    }

    @OneToMany(mappedBy = "commentid")
    private List<Replies> listReplies;


}
