package com.m.g.java.methodoverloading;

import java.io.IOException;

/**
 * If a child class throws checked exception then parent should throws either same or its parent Exception.
 *
 */

public class InheritanceThrowsClause {


}
class IParent
{
    public void m1() throws Exception {



    }
}

class IChild extends IParent
{
   public void m1() throws IOException
    {



    }
}