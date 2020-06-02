package koffieApp.rest;

import koffieApp.domain.User;
import koffieApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    UserService userService;

    /*@GetMapping("/login")
    public String loginUser(@RequestParam(required = false) String email, @RequestParam(required = false) String password){
        String loginResponse = userService.loginUser(email, password);
        if (loginResponse == "wrongEmail")
        {
            return "email didnt match any existing user";
        }
        else if (loginResponse == "loggedIn"){
            return "succesfully logged in";
        }
        else
        {
            return "Wrong password please try again";
        }
    }*/

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


}
