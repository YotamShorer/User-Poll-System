package Poll_System.controller;

import Poll_System.Service.PollService;
import Poll_System.external_api.UsersSystemService;
import Poll_System.model.Answer;
import Poll_System.model.Question;
import Poll_System.model.UserIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/polls")
public class PollsController {

    @Autowired
    private PollService pollService;

    @Autowired
    private UsersSystemService userSystemService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createQuestion(@RequestBody Question question) {
        if (question == null || question.getTitle() == null || question.getFirstAnswer() == null) {
            return ResponseEntity.badRequest().body("Invalid question data.");
        }
        return ResponseEntity.ok(pollService.createQuestion(question));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Question question = pollService.getQuestionById(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
        if (question == null || question.getId() == null) {
            return ResponseEntity.badRequest().body("Cannot update a question without a valid ID.");
        }
        return ResponseEntity.ok(pollService.updateQuestion(question));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid question ID for deletion.");
        }
        return ResponseEntity.ok(pollService.deleteQuestionById(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = pollService.getAllQuestions();
        if (questions == null || questions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(questions);
    }

    @PostMapping(value = "/answer-the-question")
    public ResponseEntity<String> answerTheQuestion(@RequestBody Answer answer) {
        if (answer == null || answer.getUserId() == null || answer.getQuestionId() == null) {
            return ResponseEntity.badRequest().body("Incomplete answer data. User ID and Question ID are required.");
        }

        UserIdResponse userIdResponse = userSystemService.isRegistered(answer.getUserId());
        if (userIdResponse == null) {
            return ResponseEntity.badRequest().body("You must register before answering any questions!");
        }

        return ResponseEntity.ok(pollService.answerTheQuestion(answer));
    }

    @DeleteMapping(value = "/delete-answers-by-user/{id}")
    public ResponseEntity<String> deleteAnswerByUserId(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid user ID for deletion.");
        }
        return ResponseEntity.ok(pollService.deleteAnswerByUserId(id));
    }

    @GetMapping(value = "/numbers-of-answers-to-question/{id}")
    public ResponseEntity<Integer> getNumberOfAnswerToQuestion(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Integer count = pollService.getNumberOfAnswerToQuestion(id);
        return ResponseEntity.ok(count);
    }
}
