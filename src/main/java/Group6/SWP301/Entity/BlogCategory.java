package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blog_category")
public class BlogCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogcategoryid;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "blogcategoryid")
    List<Blogs> listBlog;

    public int getBlogCategoryID() {
        return blogcategoryid;
    }

    public void setBlogCategoryID(int blogCategoryID) {
        blogcategoryid = blogCategoryID;
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

    public int getBlogcategoryID() {
        return blogcategoryid;
    }

    public void setBlogcategoryID(int blogcategoryID) {
        blogcategoryid = blogcategoryID;
    }

    public List<Blogs> getListBlog() {
        return listBlog;
    }

    public void setListBlog(List<Blogs> listBlog) {
        this.listBlog = listBlog;
    }

    @Override
    public String toString() {
        return "BlogCategory{" +
                "BlogCategoryID=" + blogcategoryid +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
