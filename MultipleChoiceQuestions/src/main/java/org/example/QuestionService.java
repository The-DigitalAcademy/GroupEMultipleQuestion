package org.example;

import java.util.*;

public class QuestionService implements QuestionInterface {

    private final List<Question> questionList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private int correctAnswers = 0;
    int randomQuestionNum = 10;
    String userName;

    @Override
    public void welcomeMessage() {
        System.out.println("Welcome to our quiz Challenge");
        System.out.print("Please enter your name: ");
        userName = scanner.nextLine();
        System.out.println("Thank you, " + userName + "! Let's begin the quiz.");

        getQuestion();
    }

    @Override
    public void randomQuestion() {

        //only store unique question number
        Set<Integer> questionNum = new HashSet<>();
        Random random = new Random();

        //while questions are less than 10 - keep adding
        while (questionNum.size() < randomQuestionNum) {
            int index = random.nextInt(questionList.size());
            questionNum.add(index);
        }

        List<Question> selectedQuestions = new ArrayList<>();
        for (int idx : questionNum) {
            selectedQuestions.add(questionList.get(idx));
        }

        for (Question q : selectedQuestions) {
            System.out.println("Q" + q.getId() + ": " + q.getQuestion());

            String[] options = q.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }

            System.out.print("Your answer (choose number): ");
            String input = scanner.nextLine();
            validateAnswer(input, q);
            System.out.println("-----------------------------");
        }
        calculatePercentage();
        scanner.close();
    }

    @Override
    public void calculatePercentage() {
        System.out.println(" Quiz complete! \nYou got " + correctAnswers + " out of " + randomQuestionNum + " correct.");
        double totalScore = ((double) correctAnswers / randomQuestionNum) * 100;
        System.out.println( userName + " You scored : " + totalScore + "%");

        if (totalScore >= 80) {
            System.out.println("Excellent score!");
        } else if (totalScore >= 50) {
            System.out.println("Pass!");
        } else if (totalScore >= 40) {
            System.out.println("Supplementary score!");
        }else {
            System.out.println("Failed!");
        }
    }

    //compare answers and increase count
    public void validateAnswer(String input, Question q) {
        try {
            int selectedIndex = Integer.parseInt(input) - 1;
            String[] options = q.getOptions();

            if (selectedIndex >= 0 && selectedIndex < options.length) {
                String selectedAnswer = options[selectedIndex];
                if (selectedAnswer.equalsIgnoreCase(q.getAnswer())) {
                    correctAnswers++;
                }else {
//                    System.out.println("wrong answer. correct answer is " + q.getAnswer());
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Skipping...");
        }
    }



    public void getQuestion() {
        System.out.println("Select the correct answer from options below:\n");
        loadQuestions();
        randomQuestion();
    }

    public void loadQuestions() {
        questionList.add(new Question("1", "What is the best series of all time?",
                new String[]{"The Sopranos", "The Wire", "Breaking Bad", "Game of Thrones", "Prison Break"}, "The Wire"));
        questionList.add(new Question("2", "Who is the most successful pop artist?",
                new String[]{"Stevie Wonder", "Prince", "Michael Jackson"}, "Michael Jackson"));
        questionList.add(new Question("3", "Who is the boxer with the most consecutive title defenses in the heavyweight division?",
                new String[]{"Joe Louis", "Muhammad Ali", "Lennox Lewis", "Wladimir Klitschko"}, "Joe Louis"));
        questionList.add(new Question("4", "Who are the wealthiest Jewish family who owns banking corporations?",
                new String[]{"Oppenheimer family", "Rothschild family"}, "Rothschild family"));
        questionList.add(new Question("5", "Which is the fiercest animal in the jungle?",
                new String[]{"Tiger", "Lion", "Silver back Gorilla", "Elephant"}, "Silver back Gorilla"));
        questionList.add(new Question("6", "What is the worst movie in the world?",
                new String[]{"Fast and Furious", "Titanic", "Spiderman", "John Wick", "Notebook"}, "Fast and Furious"));
        questionList.add(new Question("7", "Which language is primarily used for Android development?",
                new String[]{"Java", "Python", "C#", "Swift"}, "Java"));
        questionList.add(new Question("8", "Who painted the Mona Lisa?",
                new String[]{"Van Gogh", "Da Vinci", "Picasso", "Rembrandt"}, "Da Vinci"));
        questionList.add(new Question("9", "Which city has the most attractive women?",
                new String[]{"South Africa", "Peru", "United States of America", "Colombia", "Japan"}, "Colombia"));
        questionList.add(new Question("10", "Who is the most dangerous fictional hitman?",
                new String[]{"Jason Bourne", "John Wick", "Jack Reacher"}, "John Wick"));
        questionList.add(new Question("11", "Who is the most dangerous of the 80s four kings?",
                new String[]{"Sugar Ray Leonard", "Roberto Duran", "Marvin Hagler", "Thomas Hearns", "Wilfred Benitez"}, "Thomas Hearns"));
        questionList.add(new Question("12", "Which country is notorious for colonization?",
                new String[]{"England", "United States of America", "France"}, "England"));
        questionList.add(new Question("13", "Who is the most sadistic dictator of all time?",
                new String[]{"Kim Jong Un", "Adolf Hitler", "Joseph Stalin", "Idi Amin", "Saddam Hussein", "Muammar Gaddafi"}, "Saddam Hussein"));
        questionList.add(new Question("14", "Which clothing brand was the biggest in the urban scene in America?",
                new String[]{"Adidas", "Karl Kani", "Fubu"}, "Karl Kani"));
        questionList.add(new Question("15", "Who is the greatest rapper of all time?",
                new String[]{"Tupac Shakur", "Jay-Z", "Notorious B.I.G", "Eminem", "Nas", "Ghostface Killah"}, "Tupac Shakur"));
    }
}
