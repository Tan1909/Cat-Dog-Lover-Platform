package Group6.SWP301.model.dto.response;

import Group6.SWP301.Entity.Item;
import Group6.SWP301.Entity.Pet;

import java.util.List;

public class listPetandItemRespone {
    private List<Item> listItem;
    private List<Pet> listPet;

    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
    }

    public List<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(List<Pet> listPet) {
        this.listPet = listPet;
    }
}
