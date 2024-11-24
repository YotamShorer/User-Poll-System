package Poll_System.Service;

import Poll_System.model.Answer;
import Poll_System.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public String saveAnswer(Answer answer) {
        return answerRepository.createAnswer(answer);
    }

    public String deleteAnswersByUserId(Integer userId) {
        return answerRepository.deleteAnswersByUserId(userId);
    }
}
