package Poll_System.Service;

import Poll_System.model.Answer;
import Poll_System.model.Question;

public interface PollServiceInterface {
    String createQuestion(Question question);

    Question getQuestionById(Integer id);

    String updateQuestion(Question question);

    String deleteQuestionById(Integer id);

    String getAllQuestions();

    String answerTheQuestion(Answer answer);

    String deleteAnswerByUserId(Integer id);

    Integer getNumberOfAnswerToQuestion(Integer id);
}

