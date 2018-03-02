package com.m.g.java.immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ImmutableClass {
   private final int id;
   private final String name;
   private List<String> alist;
    ImmutableClass(int id,String name,String alist)
    {
        this.id=id;
        this.name=name;
        this.alist=new ArrayList<>();
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    public List<String> getAlist() {
        List<String> al=new ArrayList<>();
        for(String n:al)
        return alist;
    }
}

