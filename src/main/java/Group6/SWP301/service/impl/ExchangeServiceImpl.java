package Group6.SWP301.service.impl;

import Group6.SWP301.Entity.Pet;
import Group6.SWP301.Entity.PetExchange;
import Group6.SWP301.Entity.RequestPetExchange;
import Group6.SWP301.Entity.UserAccount;
import Group6.SWP301.model.dto.request.PetRequestCreate;
import Group6.SWP301.repository.UseraccountRepository;
import Group6.SWP301.repository.petExchangeRepository;
import Group6.SWP301.repository.petRepository;
import Group6.SWP301.repository.requestPetExchangeRepository;
import Group6.SWP301.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ExchangeServiceImpl implements IExchangeService {
    @Autowired
    requestPetExchangeRepository exchangeRepository;
    @Autowired
    petRepository petRepository;
    @Autowired
    UseraccountRepository useraccountRepository;
    @Override
    public List<RequestPetExchange> getListPetExchange() {
        return exchangeRepository.findAllByStatusFalse();
    }

    @Override
    public boolean createRequestPetExchange(PetRequestCreate requets) {

        RequestPetExchange _requets = new RequestPetExchange();
        Date date = new Date();

        _requets.setStatus(false);
        _requets.setPetexchangedate(date);
        _requets.setAccept(false);
        _requets.setNote(requets.getNote());

        Pet pet = petRepository.findByPetID(requets.getPetid());
        _requets.setPetid(pet);
        UserAccount userEntity = useraccountRepository.findById(requets.getUserid())
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + requets.getUserid() + " does not exist!"));
      _requets.setUserid(userEntity);
        try {
            exchangeRepository.save(_requets);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    }




