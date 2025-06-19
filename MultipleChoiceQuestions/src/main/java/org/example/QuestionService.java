package org.example;

import java.util.*;

public class QuestionService implements QuestionInterface {

    private List<Question> questionList = new ArrayList<>();

    @Override
    public void welcomeMessage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our quiz Challenge  ");
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Thank you, " + userName + "! Let's begin the quiz.");
        System.out.println("...");

        scanner.close();
        randomQuestion();
    }

    @Override
    public void userAnswer() {

    }

    @Override
    public void calculateScores() {

    }

    //choose 10 rondom questions
    @Override
    public void randomQuestion() {
        int randomQuestionNum = 10;
        Set<Integer> questionNum = new HashSet<>();
        int count = 0;


        while (questionNum.size() < randomQuestionNum) {
            int randomNum = (int)(Math.random() * 16); // 0 to 15
            questionNum.add(randomNum);
        }
        System.out.println("Unique random numbers: " + questionNum);
    }

    public void loadQuestions() {
        questionList.add(new Question("1", "What is the best series of all time?",
                new String[]{"The Sopranos", "The Wire", "Breaking Bad", "Game of Thrones","Prison Break"}, "The Wire"));

        questionList.add(new Question("2", "Who is the most successful pop artist?",
                new String[]{"Stevie Wonder", "Prince", "Michael Jackson"}, "Michael Jackson"));

        questionList.add(new Question("3", "Who is the boxer with the most consecutive title defenses in the heavyweight division?",
                new String[]{"Joe Louis", "Muhammad Ali", "Lennox Lewis", "Wladimir Klitschko"}, "Joe Louis"));

        questionList.add(new Question("4", "Who are the wealthiest Jewish family who owns banking corporations?",
                new String[]{"Oppenheimer family", "Rothschild family"}, "Rothschild family"));

        questionList.add(new Question("5", "Which is the fiercest animal in the jungle",
                new String[]{"Tiger", "Lion", "Silver back Gorilla", "Elephant"}, "Silver back Gorilla"));


        questionList.add(new Question("6", "What is the worst movie in the world?",
                new String[]{"Fast and Furious", "Titanic", "Spiderman", "John Wick","Notebook"}, "Fast and Furious"));

        questionList.add(new Question("7", "Which language is primarily used for Android development?",
                new String[]{"Java", "Python", "C#", "Swift"}, "Java"));

        questionList.add(new Question("8", "Who painted the Mona Lisa?",
                new String[]{"Van Gogh", "Da Vinci", "Picasso", "Rembrandt"}, "Da Vinci"));

        questionList.add(new Question("9", "Which city has the most attractive women?",
                new String[]{"South Africa", "Peru", "United States of America", "Colombia","Japan"}, "Colombia"));

        questionList.add(new Question("10", "Who is the most dangerous fictional hitman?",
                new String[]{"Jason Bourne", "John Wick", "Jack Reacher"}, "John Wick"));

        questionList.add(new Question("11", "Who is the most dangerous of the 80s four kings?",
                new String[]{"Sugar Ray Leonard", "Roberto Duran", "Marvin Hagler", "Thomas Hearns","Wilfred Benitez"}, "Thomas Hearns"));

        questionList.add(new Question("12", "Which country is notorious for colonization?",
                new String[]{"England", "United States of America", "France"}, "England"));

        questionList.add(new Question("13", "Who is the most sadistic dictator of all time?",
                new String[]{"Kim Jong Un", "Adolf Hitler", "Joseph Stalin","Idi Amin","Saddam Hussein","Muammar Gaddafi"}, "Saddam Hussein"));

        questionList.add(new Question("14", "Which clothing brand was the biggest in the urban scene in America?",
                new String[]{"Adidas", "Karl Kani", "Fubu"}, "Karl Kani"));

        questionList.add(new Question("15", "Who is the greatest rapper of all time?",
                new String[]{"Tupac Shakur", "Jay-Z", "Notorious B.I.G", "Eminem", "Nas", "Ghostface Killah"}, "Tupac Shakur"));


        for (int i = 0; i <= 15; i++) {
            questionList.add(new Question(String.valueOf(i), "Sample question " + i,
                    new String[]{"Option A", "Option B", "Option C", "Option D"}, "Option A"));
        }
    }

    public List<Question> getQuestions() {
        return questionList;
    }
}

