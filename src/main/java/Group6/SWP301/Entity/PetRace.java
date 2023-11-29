package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet_race")
public class PetRace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int petraceid;
    @Column(name = "name")
    private String name;
    @Column(name = "breed")
    private String breed;
    @Column(name = "image")
    private String image;
@OneToMany(mappedBy = "petRace")
private List<Pet> listPet;
    @Override
    public String toString() {
        return "PetRace{" +
                "PetRaceId=" + petraceid +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public int getPetRaceId() {
        return petraceid;
    }

    public void setPetRaceId(int petRaceId) {
        petRaceId = petRaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPetraceid() {
        return petraceid;
    }

    public void setPetraceid(int petraceid) {
        this.petraceid = petraceid;
    }

    public List<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(List<Pet> listPet) {
        this.listPet = listPet;
    }
}
