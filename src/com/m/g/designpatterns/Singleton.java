package com.m.g.designpatterns;

enum Student {
    INSTANCE("PUBLICSCHOOL");

    String school;

    Student(String publicschool) {
        this.school = publicschool;
    }
}


public class Singleton
{
    public static void main(String[] args) {

        Student s1 = Student.INSTANCE;
        Student s2 = Student.INSTANCE;
        Student s3 = Student.INSTANCE;
        Student s4 = Student.INSTANCE;

        System.out.println("S1 :"+s1.hashCode());
        System.out.println("S2 :"+s2.hashCode());
        System.out.println("S3 :"+s3.hashCode());
        System.out.println("S4 :"+s4.hashCode());
    }
}