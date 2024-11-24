package Poll_System.model;

public class Answer {

    private Integer id;
    private Integer answerNumber;
    private Integer questionId;
    private Integer userId;

    public Answer() {}

    public Answer(Integer id, Integer answerNumber, Integer questionId, Integer userId) {
        this.id = id;
        this.answerNumber = answerNumber;
        this.questionId = questionId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isValid() {
        return answerNumber != null && questionId != null && userId != null;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerNumber=" + answerNumber +
                ", questionId=" + questionId +
                ", userId=" + userId +
                '}';
    }
}
