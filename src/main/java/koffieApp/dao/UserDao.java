package koffieApp.dao;

import koffieApp.repository.UserCrudRepository;
import koffieApp.domain.User;
import koffieApp.repository.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  UserDao implements UserDaoInterface<User> {
    
    @Autowired
    private UserCrudRepository crudRepo;
    @Autowired
    private UserQueryRepository queryRepo;

    @Override
    public User getUserById(int id) {
        return crudRepo.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> listOfAllUsers = new ArrayList<>();
        crudRepo.findAll().forEach(User -> listOfAllUsers.add(User));
        return  listOfAllUsers;
    }

    @Override
    public void saveUser(User user) {
        crudRepo.save(user);
    }

    @Override
    public void updateUser(User user, String[] params) {
        int userId = user.getId();
        User userInDb = crudRepo.findById(userId).get();
        userInDb = user;
        crudRepo.save(userInDb);
    }

    @Override
    public void deleteUser(User user) {
        crudRepo.deleteById(user.getId());
    }

    @Override
    public User getUserByUsername(String username)
    {
        User user = queryRepo.findUserByUsername(username);
        return user;
    }


}
