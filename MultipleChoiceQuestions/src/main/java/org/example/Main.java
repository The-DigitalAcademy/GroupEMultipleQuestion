package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuestionService questionService = new QuestionService();

        // Show welcome message
        questionService.welcomeMessage();

        // Load questions into memory
        questionService.loadQuestions();

        // Get the questions
        List<Question> questions = questionService.getQuestions();

        // Show all questions (optional)
        for (Question q : questions) {
            System.out.println("Q" + q.getId() + ": " + q.getQuestion());
            String[] options = q.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.println();
        }
    }
}
