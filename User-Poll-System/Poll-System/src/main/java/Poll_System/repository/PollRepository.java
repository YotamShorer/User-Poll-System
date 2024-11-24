package Poll_System.repository;

import Poll_System.model.Answer;
import Poll_System.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PollRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUESTION_TABLE = "question";

    public String createQuestion(Question question) {
        try {
            String sql = String.format(
                    "INSERT INTO %s (title, first_answer, second_answer, third_answer, fourth_answer) VALUES (?, ?, ?, ?, ?)",
                    QUESTION_TABLE
            );
            jdbcTemplate.update(sql, question.getTitle(), question.getFirstAnswer(), question.getSecondAnswer(), question.getThirdAnswer(), question.getFourthAnswer());
            return "Question created successfully!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Question getQuestionById(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE id = ?", QUESTION_TABLE);
            return jdbcTemplate.queryForObject(sql, new QuestionMapper(), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String updateQuestion(Question question) {
        try {
            String sql = String.format(
                    "UPDATE %s SET title = ?, first_answer = ?, second_answer = ?, third_answer = ?, fourth_answer = ? WHERE id = ?",
                    QUESTION_TABLE
            );
            jdbcTemplate.update(sql, question.getTitle(), question.getFirstAnswer(), question.getSecondAnswer(), question.getThirdAnswer(), question.getFourthAnswer(), question.getId());
            return "Question updated successfully!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String deleteQuestionById(Integer id) {
        try {
            String sql = String.format("DELETE FROM %s WHERE id = ?", QUESTION_TABLE);
            jdbcTemplate.update(sql, id);
            return "Question deleted successfully!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<Question> getAllQuestions() {
        try {
            String sql = String.format("SELECT * FROM %s", QUESTION_TABLE);
            return jdbcTemplate.query(sql, new QuestionMapper());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String createAnswer(Answer answer) {
        try {
            String sql = "INSERT INTO answer (answer_number, question_id, user_id) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, answer.getAnswerNumber(), answer.getQuestionId(), answer.getUserId());
            return "Answer submitted successfully!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public String deleteAnswerByUserId(Integer userId) {
        try {
            String sql = "DELETE FROM answer WHERE user_id = ?";
            jdbcTemplate.update(sql, userId);
            return "All answers from user ID " + userId + " were deleted successfully!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public Integer getNumberOfAnswersToQuestion(Integer questionId) {
        try {
            String sql = "SELECT COUNT(*) FROM answer WHERE question_id = ?";
            return jdbcTemplate.queryForObject(sql, Integer.class, questionId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

}
