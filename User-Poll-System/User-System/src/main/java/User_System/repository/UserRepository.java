package User_System.repository;

import User_System.external_api.PollsSystemService;
import User_System.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PollsSystemService pollsSystemService;

    private static final String USER_TABLE = "users";

    @Override
    public String createUser(User user) {
        try {
            String sql = String.format("INSERT INTO %s (first_name, last_name, email, age, address, joining_date) VALUES (?, ?, ?, ?, ?, ?)", USER_TABLE);
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), user.getJoiningDate());
            return "User created successfully!";
        } catch (Exception e) {
            return "Error creating user: " + e.getMessage();
        }
    }

    @Override
    public User getUserById(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE id = ?", USER_TABLE);
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        } catch (Exception e) {
            System.out.println("Error retrieving user: " + e.getMessage());
            return null;
        }
    }

    @Override
    public String updateUser(User user) {
        try {
            String sql = String.format("UPDATE %s SET first_name = ?, last_name = ?, email = ?, age = ?, address = ?, joining_date = ? WHERE id = ?", USER_TABLE);
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), user.getJoiningDate(), user.getId());
            return "User updated successfully!";
        } catch (Exception e) {
            return "Error updating user: " + e.getMessage();
        }
    }

    @Override
    public String deleteUserById(Integer id) {
        try {
            String sql = String.format("DELETE FROM %s WHERE id = ?", USER_TABLE);
            jdbcTemplate.update(sql, id);
            return "User deleted successfully!";
        } catch (Exception e) {
            return "Error deleting user: " + e.getMessage();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            String sql = String.format("SELECT * FROM %s", USER_TABLE);
            return jdbcTemplate.query(sql, new UserMapper());
        } catch (Exception e) {
            System.out.println("Error retrieving users: " + e.getMessage());
            return null;
        }
    }
}
