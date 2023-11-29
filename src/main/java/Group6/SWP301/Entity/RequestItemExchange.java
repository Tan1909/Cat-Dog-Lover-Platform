package Group6.SWP301.Entity;

import javax.management.ObjectName;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_item_exchange")
public class RequestItemExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reitemexchange_id;
    @Column(name = "itemexchangedate")
    private Date itemexchangedate;
    @Column(name = "note")
    private String note;
    @Column(name = "status")
    private boolean status;
    @Column(name = "accept")
    private boolean accept;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item itemid;

    @ManyToOne
    @JoinColumn(name = "itemexchange_id")
    private ItemExchange itemExchange_id;

    public int getReitemexchange_id() { return reitemexchange_id;}

    public void setReitemexchange_id(int reitemexchange_id) {
        this.reitemexchange_id = reitemexchange_id;
    }

    public Date getItemexchangedate() {
        return itemexchangedate;
    }

    public void setItemexchangedate(Date itemexchangedate) {
        this.itemexchangedate = itemexchangedate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getLocation() {
        return accept;
    }

    public void setLocation(boolean accept) {
        this.accept = accept;
    }

    public UserAccount getUserid() {
        return userid;
    }

    public void setUserid(UserAccount userid) {
        this.userid = userid;
    }

    public Item getItemid() {
        return itemid;
    }

    public void setItemid(Item itemid) {
        this.itemid = itemid;
    }

    public ItemExchange getItemExchange_id() {
        return itemExchange_id;
    }

    public void setItemExchange_id(ItemExchange itemExchange_id) {
        this.itemExchange_id = itemExchange_id;
    }
}
