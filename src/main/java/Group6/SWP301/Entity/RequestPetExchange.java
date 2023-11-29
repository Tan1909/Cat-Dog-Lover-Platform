package Group6.SWP301.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_pet_exchange")
public class    RequestPetExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int repetexchange_id;
    @Column(name = "petexchangedate")
    private Date petexchangedate;
    @Column(name = "note")
    private String note;
    @Column(name = "status")
    private boolean status;
    @Column(name = "accept")
    private boolean accept;

    @ManyToOne
    @JoinColumn(name = "petid")
    private Pet petid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserAccount userid;

    @ManyToOne
    @JoinColumn(name = "petexchange_id")
    private PetExchange petexchange_id;

    public int getRepetexchange_id() {
        return repetexchange_id;
    }

    public void setRepetexchange_id(int repetexchange_id) {
        this.repetexchange_id = repetexchange_id;
    }

    public Date getPetexchangedate() {
        return petexchangedate;
    }

    public void setPetexchangedate(Date petexchangedate) {
        this.petexchangedate = petexchangedate;
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

    public boolean getAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public Pet getPetid() {
        return petid;
    }

    public void setPetid(Pet petid) {
        this.petid = petid;
    }

    public UserAccount getUserid() {
        return userid;
    }

    public void setUserid(UserAccount userid) {
        this.userid = userid;
    }

    public PetExchange getPetexchange_id() {
        return petexchange_id;
    }

    public void setPetexchange_id(PetExchange petexchange_id) {
        this.petexchange_id = petexchange_id;
    }
}
