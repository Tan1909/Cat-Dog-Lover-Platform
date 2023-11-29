package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ItemID;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "date_create")
    private Date datecreate;
    @Column(name = "date_update")
    private Date dateupdate;
    @Column(name = "status")
    private int status;
    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "subcategoryid")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;


    @OneToMany(mappedBy = "itemid")
    private List<ItemExchange> listitem;
@OneToMany(mappedBy = "itemid")
private List<Report> listReport;
    @Override
    public String toString() {
        return "Item{" +
                "ItemID=" + ItemID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", datecreate=" + datecreate +
                ", dateupdate=" + dateupdate +
                ", status=" + status +
                ", image='" + image + '\'' +
                ", subCategory=" + subCategory +
                ", userid=" + userid +
                '}';
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public UserAccount getUserid() {
        return userid;
    }

    public void setUserid(UserAccount userid) {
        this.userid = userid;
    }
}
