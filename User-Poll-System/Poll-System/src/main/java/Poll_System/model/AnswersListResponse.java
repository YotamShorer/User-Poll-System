package Poll_System.model;

import java.util.List;

public class AnswersListResponse {

    private List<Answer> answersList;

    public AnswersListResponse() {}

    public AnswersListResponse(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public Integer getSize() {
        return answersList != null ? answersList.size() : 0;
    }

    public String toQuestionOptions() {
        if (answersList == null || answersList.isEmpty()) {
            return "No answers available.";
        }

        int firstCounter = 0, secondCounter = 0, thirdCounter = 0, fourthCounter = 0;
        Integer questionId = answersList.get(0).getQuestionId();

        for (Answer answer : answersList) {
            switch (answer.getAnswerNumber()) {
                case 1 -> firstCounter++;
                case 2 -> secondCounter++;
                case 3 -> thirdCounter++;
                case 4 -> fourthCounter++;
            }
        }

        return String.format(
                "Question ID %d Results:\n" +
                        "First option: %d votes\n" +
                        "Second option: %d votes\n" +
                        "Third option: %d votes\n" +
                        "Fourth option: %d votes",
                questionId, firstCounter, secondCounter, thirdCounter, fourthCounter
        );
    }

    @Override
    public String toString() {
        if (answersList == null || answersList.isEmpty()) {
            return "No answers to display.";
        }

        StringBuilder result = new StringBuilder("User answers:\n");
        for (Answer answer : answersList) {
            result.append(answer).append("\n");
        }
        return result.toString();
    }
}
