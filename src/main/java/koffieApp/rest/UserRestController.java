package koffieApp.rest;

import koffieApp.domain.User;
import koffieApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    UserService userService;



    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user){
        String response = userService.registerUser(user);
        if (response == "nameExists"){
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
    }

    @GetMapping("/user")
    public User getLoggedInUser(){
        return userService.getLoggedInUser();
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody User user){
        String response = userService.updateUser(user);
        if (response == "nameExists"){
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/user/password", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUserPassword(@RequestParam String id, @RequestParam String oldPassword, @RequestParam String newPassword){
        String response = userService.updateUserPassword(Integer.parseInt(id), oldPassword, newPassword);
        if (response == "didntMatch"){
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(
                    Collections.singletonMap("response", response), HttpStatus.OK);
        }
    }




}
