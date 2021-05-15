package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuestionModel {

    public StringProperty questionText = new SimpleStringProperty();
    public StringProperty answer = new SimpleStringProperty();

    public Question toData() {
        return new Question(questionText.get(), answer.get());
    }

    @Override
    public String toString() {
        return questionText.get();
    }

    public static class Question {

        private String questionText;

        private String answer;

        public Question() { }

        public Question(String questionText, String answer) {
            this.questionText = questionText;
            this.answer = answer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public QuestionModel toModel() {
            var model = new QuestionModel();
            model.questionText.set(questionText);
            model.answer.set(answer);
            return model;
        }
    }
}