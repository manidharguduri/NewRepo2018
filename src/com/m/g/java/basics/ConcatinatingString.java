package com.m.g.java.basics;

import java.time.Duration;
import java.time.Instant;

public class ConcatinatingString {

    public static void main(String[] args) {

        String str = "mani";

        Instant start = Instant.now();
        for(int i = 0; i < 100000000L; i++)
        {
            String str2 = str + str;
        }
        Instant end = Instant.now();

        System.out.println("Measuring the time of + operator :"+ Duration.between(start, end).getNano());

        Instant startOne = Instant.now();
        for(int i = 0; i < 100000000L; i++)
        {
            String str2 = str.concat(str);
        }
        Instant endOne = Instant.now();
        System.out.println("Measuring the time of concat method :"+ Duration.between(startOne, endOne).getNano());

        /**
         *
         *  concat is faster than +
         *
         * "string" + "string" compiles to new StringBuilder().append("string").append("string").toString().1
         * append's source uses its superclass', AbstractStringBuilder, method:

         public AbstractStringBuilder append(String str) {
         if (str == null) str = "null";
         int len = str.length();
         ensureCapacityInternal(count + len);
         str.getChars(0, len, value, count);
         count += len;
         return this;
         }
         */

    }
}
