package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleid;
    @Column(name = "rolename")
    private String rolename;
    @OneToMany(mappedBy = "rolesid")
    private List<UserAccount> listUserAccount;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<UserAccount> getListUserAccount() {
        return listUserAccount;
    }

    public void setListUserAccount(List<UserAccount> listUserAccount) {
        this.listUserAccount = listUserAccount;
    }

    @Override
    public String toString() {
        return "roles{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }

}
