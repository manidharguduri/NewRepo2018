package com.m.g.main;

import java.util.ArrayList;
import java.util.List;

public class DSQuestions {


    public static void logicalQuestions()
    {
        List<String> questions = new ArrayList<>();

        // Question : 1
        String angleInAClock = "Question : 1 : Angle Between hours hand and minutes hand ";
        questions.add(angleInAClock);



        System.out.println("Logical Questions:");
        System.out.println("==================");
        questions.forEach(System.out::print);
        System.out.println();


    }


    public  static void multiThreadingQuestion()
    {
        List<String> questions = new ArrayList<>();

        // Question : 1
        String evenAndOddThreads = "Question : 1 : Print the even and odd using inter thread communication";
        questions.add(evenAndOddThreads);
        System.out.println();
        System.out.println("Multi Threaded Questions:");
        System.out.println("==================");
        questions.forEach(System.out::print);
        System.out.println();
    }

    public static void binaryTreeQuestions()
    {
        List<String> questions = new ArrayList<>();


        System.out.println();
        System.out.println("Binary Tree Questions:");
        System.out.println("==================");
        questions.forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {

        logicalQuestions();
        multiThreadingQuestion();
        binaryTreeQuestions();
    }
}
