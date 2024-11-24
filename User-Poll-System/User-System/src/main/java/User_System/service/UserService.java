package User_System.service;

import User_System.model.User;
import User_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null) {
            return "First name, last name, and email are required!";
        }
        if (user.getAge() == null) {
            user.setAge(0);
        }
        return userRepository.createUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be null!");
        }
        return userRepository.getUserById(id);
    }

    @Override
    public String updateUser(User user) {
        if (user.getId() == null) {
            return "User ID is required for updates!";
        }
        User existingUser = userRepository.getUserById(user.getId());
        if (existingUser == null) {
            return "User does not exist!";
        }

        if (user.getFirstName() == null) {
            user.setFirstName(existingUser.getFirstName());
        }
        if (user.getLastName() == null) {
            user.setLastName(existingUser.getLastName());
        }
        if (user.getEmail() == null) {
            user.setEmail(existingUser.getEmail());
        }
        if (user.getAge() == null) {
            user.setAge(existingUser.getAge());
        }
        if (user.getAddress() == null) {
            user.setAddress(existingUser.getAddress());
        }
        if (user.getJoiningDate() == null) {
            user.setJoiningDate(existingUser.getJoiningDate());
        }
        return userRepository.updateUser(user);
    }

    @Override
    public String deleteUserById(Integer id) {
        if (id == null) {
            return "User ID is required!";
        }
        User existingUser = userRepository.getUserById(id);
        if (existingUser == null) {
            return "User does not exist!";
        }
        return userRepository.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
