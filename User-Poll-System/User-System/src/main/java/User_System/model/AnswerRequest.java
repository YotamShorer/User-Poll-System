package User_System.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerRequest {

    private Integer id;

    @JsonProperty("answer_number")
    private Integer answerNumber;

    @JsonProperty("question_id")
    private Integer questionId;

    @JsonProperty("user_id")
    private Integer userId;

    public AnswerRequest() {
    }

    public AnswerRequest(Integer id, Integer answerNumber, Integer questionId, Integer userId) {
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
}
