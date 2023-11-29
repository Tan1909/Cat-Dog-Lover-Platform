package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PetID;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
@Column(name = "sex")
    private boolean sex;
@Column(name = "weight")
    private double weight;
@Column(name = "height")
    private double height;
@Column(name = "image")
    private String image;

@ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount user;

    @ManyToOne
    @JoinColumn(name = "petraceid")
    private PetRace petRace;

    @OneToMany(mappedBy = "petid")
    private List<PetExchange> listPetExchange;

    @Override
    public String toString() {
        return "Pet{" +
                "PetID=" + PetID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", weight=" + weight +
                ", height=" + height +
                ", image='" + image + '\'' +
                ", user=" + user +
                ", petRace=" + petRace +
                '}';
    }

    public int getPetID() {
        return PetID;
    }

    public void setPetID(int petID) {
        PetID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public PetRace getPetRace() {
        return petRace;
    }

    public void setPetRace(PetRace petRace) {
        this.petRace = petRace;
    }
}
