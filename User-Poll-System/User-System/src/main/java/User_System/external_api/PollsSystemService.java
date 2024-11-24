package User_System.external_api;

import User_System.model.AnswerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "externalapi",
        url = "${externalApi.polls.url}"
)
public interface PollsSystemService {

    @PostMapping(value = "/answer-the-question")
    String answerTheQuestion(@RequestBody AnswerRequest answerRequest);

    @DeleteMapping(value = "/delete-answers-by-user/{id}")
    String deleteAnswersByUserId(@PathVariable Integer id);

    @GetMapping(value = "/number-of-answers-per-user/{id}")
    Integer getNumberOfAnswersPerUser(@PathVariable Integer id);

    @GetMapping(value = "/user-answers-to-each-question-he-submitted/{id}")
    String getUserAnswersToEachQuestionHeSubmitted(@PathVariable Integer id);
}
