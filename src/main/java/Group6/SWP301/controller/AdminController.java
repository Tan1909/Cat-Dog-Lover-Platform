package Group6.SWP301.controller;/*  Welcome to Jio word
    @author: Jio
    Date: 10/9/2023
    Time: 3:24 PM
    
    ProjectName: SWP301
    Jio: I wish you always happy with coding <3
*/

import Group6.SWP301.Entity.UserAccount;
import Group6.SWP301.model.dto.request.UserDTORequest;
import Group6.SWP301.model.dto.response.UserDTOResponse;
import Group6.SWP301.model.mapper.UserMapper;
import Group6.SWP301.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final IUserService userService;

    @Autowired
    public AdminController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/staff")
    public ResponseEntity<?> getAllStaff(){
        List<UserAccount> userStaffs = userService.getAllStaff();
        return new ResponseEntity<>(UserMapper.toListUserResponse(userStaffs), HttpStatus.OK);
    }

    @PutMapping(path = "{userId}")
    public ResponseEntity<?> updateUser(@RequestBody UserDTORequest userDTORequest
        ,@PathVariable("userId") int userId){

        return new ResponseEntity<>(userService.updateUser(userDTORequest,userId), HttpStatus.OK);
    }

    @DeleteMapping("/staff/{userId}")
    public ResponseEntity<?> deleteStaff(@PathVariable("userId") int userId){

        UserDTOResponse userDTOResponse = userService.deleteStaff(userId);

        return new ResponseEntity<>(userDTOResponse,HttpStatus.OK);
    }

}
