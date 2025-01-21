package com.surveysystem;

import com.surveysystem.model.Survey;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Survey survey = new Survey();
        survey.addQuestion("What is your name?");
        survey.addQuestion("How old are you?");
        survey.addQuestion("What is your favorite programming language?");

        Scanner scanner = new Scanner(System.in);

        for (String question : survey.getQuestions()) {
            System.out.println(question);
            String response = scanner.nextLine();
            survey.addResponse(response);
        }

        System.out.println("Thank you for completing the survey!");
        System.out.println("Your responses:");
        for (String response : survey.getResponses()) {
            System.out.println(response);
        }

        scanner.close();
    }

    public Object getGreeting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGreeting'");
    }
}