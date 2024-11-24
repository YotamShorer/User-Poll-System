package Poll_System.repository;

import Poll_System.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String ANSWER_TABLE = "answer";

    public String createAnswer(Answer answer) {
        try {
            String sql = String.format(
                    "INSERT INTO %s (answer_number, question_id, user_id) VALUES (?, ?, ?)",
                    ANSWER_TABLE
            );
            jdbcTemplate.update(sql, answer.getAnswerNumber(), answer.getQuestionId(), answer.getUserId());
            return "Answer saved successfully!";
        } catch (Exception e) {
            return "Error saving answer: " + e.getMessage();
        }
    }

    public String deleteAnswersByUserId(Integer userId) {
        try {
            String sql = String.format("DELETE FROM %s WHERE user_id = ?", ANSWER_TABLE);
            jdbcTemplate.update(sql, userId);
            return "Answers deleted successfully for user ID: " + userId;
        } catch (Exception e) {
            return "Error deleting answers: " + e.getMessage();
        }
    }

    public List<Answer> getAnswersByQuestionId(Integer questionId) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE question_id = ?", ANSWER_TABLE);
            return jdbcTemplate.query(sql, new AnswerMapper(), questionId);
        } catch (Exception e) {
            System.err.println("Error retrieving answers: " + e.getMessage());
            return null;
        }
    }

    public Integer getNumberOfAnswersToQuestion(Integer questionId) {
        try {
            String sql = String.format("SELECT COUNT(*) FROM %s WHERE question_id = ?", ANSWER_TABLE);
            return jdbcTemplate.queryForObject(sql, Integer.class, questionId);
        } catch (Exception e) {
            System.err.println("Error counting answers: " + e.getMessage());
            return 0;
        }
    }
}
