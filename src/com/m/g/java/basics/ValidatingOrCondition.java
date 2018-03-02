package com.m.g.java.basics;

import javax.swing.*;

public class ValidatingOrCondition {

    public static void main(String[] args) {

        JFrame jFrame = null;

        if (true || jFrame.hasFocus()) {
            System.out.println("Only one thing is validated...");
        }

    }
}
