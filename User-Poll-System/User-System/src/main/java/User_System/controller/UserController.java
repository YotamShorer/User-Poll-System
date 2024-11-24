package User_System.controller;

import User_System.external_api.PollsSystemService;
import User_System.model.AnswerRequest;
import User_System.model.User;
import User_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PollsSystemService pollsSystemService;

    @PostMapping(value = "/create")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/update")
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/answer-the-question")
    public String answerTheQuestion(@RequestBody AnswerRequest answerRequest) {
        return pollsSystemService.answerTheQuestion(answerRequest);
    }

    @GetMapping(value = "/numbers-of-answers-per-user/{id}")
    public Integer getNumberOfAnswersPerUser(@PathVariable Integer id) {
        return pollsSystemService.getNumberOfAnswersPerUser(id);
    }

    @GetMapping(value = "/user-answers-to-each-question-he-submitted/{id}")
    public String getUserAnswersToEachQuestionHeSubmitted(@PathVariable Integer id) {
        return pollsSystemService.getUserAnswersToEachQuestionHeSubmitted(id);
    }
}
