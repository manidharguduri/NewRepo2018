package com.m.g.java.constructor;

/**
 * Public varaibles can have setters and getters.
 * But the oops principles data hiding will be violated
 * if the varaibles are public since it can be accessed b y outside world.
 *
 */

public class PublicSetterGetter {

    public String name;
    public String password;
    public  static  void main(String[] args)
    {

        PublicSetterGetter ps=new PublicSetterGetter();
        ps.setName("gayi");
        ps.setName("mani");

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
