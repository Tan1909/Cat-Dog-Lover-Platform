package Group6.SWP301.controller;

import Group6.SWP301.model.dto.request.UserDTORequest;
import Group6.SWP301.model.dto.response.UserDTOResponse;
import Group6.SWP301.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String pass){
        UserDTOResponse us = userService.login(username,pass);

        return new ResponseEntity<>(us.getUserid(), HttpStatus.OK);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody UserDTORequest userDTORequest){
        boolean check = userService.signinForUser(userDTORequest);
        if(check){
            return  new ResponseEntity<>("đăng kí thành công", HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("ko đăng kí được", HttpStatus.OK);
        }

    }

    @PostMapping ("/profile")
    public ResponseEntity<?> viewProfile(
            @RequestParam int id
    ){

        UserDTOResponse userDTOResponse = userService.profile(id);
        //System.out.println(userDTOResponse.getName());
        return new ResponseEntity<>(userDTOResponse,HttpStatus.OK);
    }
    @PostMapping("/edit")
    private ResponseEntity<?> editProfile(@RequestBody UserDTORequest userDTORequest,int id){
        boolean check = userService.editProfile(userDTORequest,id);
        if(check){
            return  new ResponseEntity<>("sửa thành công", HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("sửa thất bại", HttpStatus.OK);
        }
    }




}
