package koffieApp.service;

import koffieApp.dao.UserDao;
import koffieApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao dao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String loginUser(String email, String password){
        User user = dao.getUserByUsername(email);
        if (user == null){
            return "wrongEmail";
        }
        String userPassword = user.getPassword();
        if (userPassword.equals(password)){
            return "loggedIn";
        }
        else{
            return "wrongPassword";
        }
    }

    public void registerUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        dao.saveUser(user);
        /*if (user.getEmail() != null && user.getName() != null && user.getPassword() != null && user.getDeskLocation() != null){
            if (checkUsersIfEmailExists(user.getEmail()) == true){
                return "emailExists";
            }
            else if (checkUsersIfNameExists(user.getName()) == true){
                return "nameExists";
            }
            else if (checkUsersIfDesklocationExists(user.getDeskLocation()) == true){
                return "deskExists";
            }
            else{
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                dao.saveUser(user);
                return "userAdded";
            }
        }
        else{
            return "fillAllFields";
        }*/


    }

    public User getLoggedInUser(){
        Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user =  dao.getUserByUsername((String) username);
        return user;
    }


    public boolean checkUsersIfEmailExists(String email){
        User user = dao.getUserByUsername(email);
        if (user != null){
            return true;
        }
        else{
            return false;
        }
    }



}
