package org.example;

import java.util.Scanner;

public class QuestionService implements QuestionInterface {
    @Override
    public void welcomeMessage() {
        Scanner scanner  = new Scanner(System.in);


        // Display welcome message

        System.out.println("Welcome to our quiz Challenge  ");

        //get users name
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();


        System.out.println("Thank you, " + userName + "! Let's begin the quiz.");
        System.out.println("...");

    }
}
