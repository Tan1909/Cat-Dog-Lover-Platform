package Group6.SWP301.controller;

import Group6.SWP301.Entity.*;
import Group6.SWP301.model.dto.request.PetRequestCreate;
import Group6.SWP301.model.dto.response.listPetandItemRespone;
import Group6.SWP301.repository.itemRepository;
import Group6.SWP301.repository.petRepository;
import Group6.SWP301.repository.requestPetExchangeRepository;
import Group6.SWP301.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    @Autowired
    requestPetExchangeRepository exchangeRepository;
    @Autowired
    petRepository petRepository;
    @Autowired
    itemRepository itemRepository;
    @Autowired
    IExchangeService iExchangeService;



    @GetMapping("/listexchange")
    public ResponseEntity<?> getAllExchange(){
        List<RequestPetExchange> list = iExchangeService.getListPetExchange();

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/listpetanditem")
    public ResponseEntity<?> getlist(@RequestParam int id){
        listPetandItemRespone pai = new listPetandItemRespone();
        UserAccount userAccount = new UserAccount();
        userAccount.setUserid(id);
        List<Pet> listPet = petRepository.findByUser(userAccount);
        List<Item> listItem = itemRepository.findByUserid(userAccount);
        pai.setListItem(listItem);
        pai.setListPet(listPet);
        return new ResponseEntity<>(pai,HttpStatus.OK);
    }
        @GetMapping("/createexchange")
    public ResponseEntity<?> createexchange(@RequestBody PetRequestCreate request){
        boolean check = iExchangeService.createRequestPetExchange(request);
        return new ResponseEntity<>(check?"tạo thành công":"tạo thất bại",HttpStatus.OK);
    }
    @GetMapping("/completerequest")
    public ResponseEntity<?> complete(@RequestBody RequestPetExchange requestPetExchange,
                                      @RequestBody PetExchange petExchange){
requestPetExchange.setPetexchange_id(petExchange);
exchangeRepository.save(requestPetExchange);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

}
