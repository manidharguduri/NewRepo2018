package com.m.g.java.exception;

public class MultipleClassType {


    public static void main(String[] args) {

        Student student = new Student();
        student.id = 90;

        Object obj = student;

        GStudent gStudent = (GStudent) obj;

        System.out.println("GStudent "+gStudent.id);

        /**
         *
         * Output:
         *
         * Exception in thread "main" java.lang.ClassCastException: com.m.g.java.basics.Student cannot be cast to com.m.g.java.basics.GStudent
         at com.m.g.java.basics.MultipleClassType.main(MultipleClassType.java:13)
         */

    }

}

class Student
{
    int id;
}

class GStudent
{
    int id;
}