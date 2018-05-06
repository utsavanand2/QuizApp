package com.kumarutsavanand.quizapp;

import java.util.ArrayList;

public class QuestionAndResponses {

    public ArrayList<String> questions = new ArrayList<>(5);
    public ArrayList<String> answers = new ArrayList<>(5);

    public static String question1 = "Which android lifecycle callback is triggered when the activity is initially created?";
    public static String answer1 = "onCreate";
    public static String question2 = "Which android lifecycle callback is triggered when the activity becomes visible again?";
    public static String answer2 = "onResume";
    public static String question3 = "Which class exposes methods to manage the SQLite database in Android?";
    public static String answer3 = "SQLiteDatabase";
    public static String question4 = "Which view in require an Adapter to render its elements?";
    public static String answer4 = "ListView|GridView|RecyclerView";
    public static String question5 = "Which is the official integrated development environment for Android platform development?";
    public static String answer5 = "Android Studio";

    QuestionAndResponses() {
        questions.add(0, question1);
        questions.add(1, question2);
        questions.add(2, question3);
        questions.add(3, question4);
        questions.add(4, question5);

        answers.add(0, answer1);
        answers.add(1, answer2);
        answers.add(2, answer3);
        answers.add(3, answer4);
        answers.add(4, answer5);

    }

    public String getQuestion(int index) {
        return questions.get(index);
    }

    public String getAnswer(int index) {
        return answers.get(index);
    }
}
