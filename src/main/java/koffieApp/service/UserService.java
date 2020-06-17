package koffieApp.service;

import koffieApp.dao.UserDao;
import koffieApp.domain.User;
import koffieApp.repository.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao dao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserQueryRepository userQueryRepository;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String updateUser(User user) {
        User userWithSameName = dao.getUserByUsername(user.getUsername());
        if (userWithSameName == null) {
            dao.saveUser(user);
            return "success";
        } else {
            if (user.getId() == userWithSameName.getId()) {
                dao.saveUser(user);
                return "success";
            } else {
                return "nameExists";
            }
        }
    }

    public String updateUserPassword(int id, String oldPassword, String newPassword){
        User oldUser = dao.getUserById(id);

        if (bCryptPasswordEncoder.matches(oldPassword, oldUser.getPassword())){
            String encryptedNewPasswd = bCryptPasswordEncoder.encode(newPassword);
            oldUser.setPassword(encryptedNewPasswd);
            dao.saveUser(oldUser);
            return "success";
        }
        else {
            return "didntMatch";
        }

    }

    public String registerUser(User user){
        if (userQueryRepository.findUserByUsername(user.getUsername()) == null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            dao.saveUser(user);
            return "success";
        }
        else{
            return "nameExists";
        }

    }

    public User getLoggedInUser(){
        Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user =  dao.getUserByUsername((String) username);
        return user;
    }
}
