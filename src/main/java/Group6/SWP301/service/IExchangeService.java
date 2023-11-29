package Group6.SWP301.service;

import Group6.SWP301.Entity.PetExchange;
import Group6.SWP301.Entity.RequestPetExchange;
import Group6.SWP301.model.dto.request.PetRequestCreate;

import java.util.List;

public interface IExchangeService {
    List<RequestPetExchange> getListPetExchange();

    boolean createRequestPetExchange(PetRequestCreate requets);



}
