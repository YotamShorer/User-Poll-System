package User_System.service;

import User_System.model.User;

import java.util.List;

public interface UserServiceInterface {
    String createUser(User user);
    User getUserById(Integer id);
    String updateUser(User user);
    String deleteUserById(Integer id);
    List<User> getAllUsers();
}
