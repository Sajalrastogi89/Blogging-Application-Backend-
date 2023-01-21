package com.application.blogging_application.controllers;
import com.application.blogging_application.payloads.APIResponse;
import com.application.blogging_application.payloads.UserDTO;
import com.application.blogging_application.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

   private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create user
    @PostMapping("/")
    public ResponseEntity<UserDTO> createNewUser(@Valid @RequestBody UserDTO userDTO){

       UserDTO createdUser= this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser,HttpStatus.OK);
    }


@PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUsers(@Valid @RequestBody UserDTO user,@PathVariable Integer id){
        UserDTO user1=this.userService.updateUser(user,id);
        return ResponseEntity.ok(user1);
}
@DeleteMapping("/{id}")
        public ResponseEntity<APIResponse> deleteUser(@PathVariable Integer id){
        try{
        this.userService.deleteUserById(id);
        return new ResponseEntity<>(new APIResponse("User deleted",true),HttpStatus.OK);}
        catch (Exception e){
            return  new ResponseEntity<>(new APIResponse("User deleted",false),HttpStatus.OK);
        }
}

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOS= this.userService.getAllUsers();
        return  new ResponseEntity<>(userDTOS,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
        System.out.println();
        return new ResponseEntity<>(this.userService.getUserById(id),HttpStatus.OK);
    }

}
