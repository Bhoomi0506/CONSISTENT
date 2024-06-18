public class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

import java.util.Scanner;

public class QuizApplication {
    private Question[] questions;
    private int score;

    public QuizApplication() {
        initializeQuestions();
        score = 0;
    }

    private void initializeQuestions() {
        questions = new Question[3];  // Example: Creating 3 questions

        questions[0] = new Question(
                "who invented java programming?",
                new String[]{"1.Guido van Rossum
                2. James Gosling
                3.Dennis Ritchie
                4.jarne Stroustrup"},
                2
               
        );
        questions[1] = new Question(
                ". What is the extension of java code files?"
             new String[] {" a .js
                b .txt
                c .class
                d.java"} ,
        );
        questions[2] = new Question(
                "Which of the following is a superclass of every class in Java?"
                new String[] {" a ArrayList
                b Abstract class
                c Object class
                d String"} ,
                c
        );
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Please enter the number of your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + question.getCorrectAnswer());
            }
            System.out.println();
        }

        System.out.println("Quiz over! Your score is " + score + " out of " + questions.length);
        scanner.close();
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.start();
    }
}
