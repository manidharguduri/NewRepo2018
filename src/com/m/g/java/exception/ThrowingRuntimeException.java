package com.m.g.java.exception;

public class ThrowingRuntimeException {


    public static void main(String[] args) {


    }

    // runtime exception no need to specify the throws to a method.

    public void simpleException() throws Exception {
        try
        {

        }
        catch(Exception ex)
        {
            throw new Exception();
        }
        finally
        {

        }
    }
}
