package Group6.SWP301.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item_categories")
public class SubCategory {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subcategoryid;
@Column(name = "name")
    private String name;
@Column(name = "status")
    private boolean status;

@OneToMany(mappedBy = "subCategory")
    private List<Item> list;


    @Override
    public String toString() {
        return "SubCategory{" +
                "subcategoryid=" + subcategoryid +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public int getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(int subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
