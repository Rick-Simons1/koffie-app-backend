package koffieApp.rest;

import koffieApp.domain.User;
import koffieApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    UserService userService;



    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        userService.registerUser(user);
        /*String registerResponse = */
        /*if (registerResponse == "emailExists"){
            return "email adress already exists";
        }
        else if (registerResponse == "nameExists")
        {
            return "name already exists";
        }
        else if (registerResponse == "deskExists")
        {
            return  "desk location already exists";
        }
        else{
            return "user registered succesfully";
        }*/
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/user")
    public User getLoggedInUser(){
        return userService.getLoggedInUser();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/user/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> updateUser(@RequestBody User user){
        String response = userService.updateUser(user);
        return Collections.singletonMap("response", response);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/user/update/password", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> updateUserPassword(@RequestParam String id, @RequestParam String oldPassword, @RequestParam String newPassword){
        String response = userService.updateUserPassword(Integer.parseInt(id), oldPassword, newPassword);
        return Collections.singletonMap("response", response);
    }




}
