package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "replies")
public class Replies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyid;
    @Column(name = "datecreate")
    private Date datecreate;
    @Column(name = "dateupdate")
    private Date dateupdate;
    @Column(name = "replycontent")
    private String replycontent;
    @Column(name = "status")
    private int status;
    @Column(name = "reasonhiden")
    private String reasonhiden;

    @ManyToOne
    @JoinColumn(name = "commentid")
    private Comments commentid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
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

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReasonhiden() {
        return reasonhiden;
    }

    public void setReasonhiden(String reasonhiden) {
        this.reasonhiden = reasonhiden;
    }

    public Comments getCommentid() {
        return commentid;
    }

    public void setCommentid(Comments commentid) {
        this.commentid = commentid;
    }

    public UserAccount getUserid() {
        return userid;
    }

    public void setUserid(UserAccount userid) {
        this.userid = userid;
    }
}
