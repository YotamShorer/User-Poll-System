package Poll_System.Service;

import Poll_System.model.Answer;
import Poll_System.model.Question;
import Poll_System.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public String createQuestion(Question question) {
        if (question == null || question.getTitle() == null) {
            return "Invalid question data.";
        }
        return pollRepository.createQuestion(question);
    }

    public Question getQuestionById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid question ID.");
        }
        return pollRepository.getQuestionById(id);
    }

    public String updateQuestion(Question question) {
        if (question == null || question.getId() == null) {
            return "Cannot update a question without a valid ID.";
        }
        return pollRepository.updateQuestion(question);
    }

    public String deleteQuestionById(Integer id) {
        if (id == null || id <= 0) {
            return "Invalid question ID for deletion.";
        }
        return pollRepository.deleteQuestionById(id);
    }

    public List<Question> getAllQuestions() {
        return pollRepository.getAllQuestions();
    }

    public String answerTheQuestion(Answer answer) {
        if (answer == null || !answer.isValid()) {
            return "Invalid answer data.";
        }
        return pollRepository.createAnswer(answer);
    }

    public String deleteAnswerByUserId(Integer id) {
        if (id == null || id <= 0) {
            return "Invalid user ID for deletion.";
        }
        return pollRepository.deleteAnswerByUserId(id);
    }

    public Integer getNumberOfAnswerToQuestion(Integer questionId) {
        if (questionId == null || questionId <= 0) {
            throw new IllegalArgumentException("Invalid question ID.");
        }
        return pollRepository.getNumberOfAnswersToQuestion(questionId);
    }
}
