package org.example;

public class Question {
    private String id;
    private String Question;
    private String[] options;
    private String answer;


    public Question(String id, String question, String[] options, String answer) {
        this.id = id;
        this.Question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
