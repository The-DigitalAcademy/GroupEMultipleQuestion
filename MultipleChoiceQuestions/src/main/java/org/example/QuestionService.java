package org.example;

import java.util.Scanner;

public class QuestionService implements QuestionInterface {
    @Override
    public void welcomeMessage() {
        Scanner scanner  = new Scanner(System.in);

        System.out.println("Welcome to our quiz Challenge ");

    }
}
