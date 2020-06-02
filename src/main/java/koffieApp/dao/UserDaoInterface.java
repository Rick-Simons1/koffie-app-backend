package koffieApp.dao;

import java.util.List;
import java.util.Optional;

public interface UserDaoInterface<User> {

    User getUserById(int id);

    List<User> getAllUsers();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserByUsername(String email);
}
