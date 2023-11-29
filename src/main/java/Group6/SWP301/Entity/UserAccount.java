package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Userid;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "gmail")
    private String gmail;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "sex")
    private boolean sex;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "datecreate")
    private Date datecreate;
    @Column(name = "dateupdate")
    private Date dateupdate;
    @Column(name = "image")
    private String image;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private boolean status;
//@Column(name = "roleid")
//    private int roleid;
    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    private Roles rolesid;

    @OneToMany(mappedBy = "userid")
    private List<ItemExchange> listItemExchange;

    @OneToMany(mappedBy = "userid")
    private List<PetExchange> listPetExchange;

@OneToMany(mappedBy = "user")
private List<Pet> listPet;
@OneToMany(mappedBy = "userid")
private List<Item> listItem;
@OneToMany(mappedBy = "userid")
private List<Blogs> listBlog;
@OneToMany(mappedBy = "userid")
private List<Comments> listComment;
@OneToMany(mappedBy = "userid")
private List<Replies> listReplies;

    @OneToMany(mappedBy = "userid")
    private List<Feedback> listFeedback;

    @Override
    public String toString() {
        return "UserAccount{" +
                "Userid=" + Userid +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", dob=" + dob +
                ", datecreate=" + datecreate +
                ", dateupdate=" + dateupdate +
                ", image='" + image + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", rolesid=" + rolesid +
                '}';
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Roles getRolesid() {
        return rolesid;
    }

    public void setRolesid(Roles rolesid) {
        this.rolesid = rolesid;
    }

    public List<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(List<Pet> listPet) {
        this.listPet = listPet;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
    }

    public List<Blogs> getListBlog() {
        return listBlog;
    }

    public void setListBlog(List<Blogs> listBlog) {
        this.listBlog = listBlog;
    }
}
