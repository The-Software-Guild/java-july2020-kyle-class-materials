package com.sg.helloworld;

import com.sg.another.ControlFlowStuff;

/**
 *
 * @author Kyle David Rudy
 */
public class Stuff {
    
    boolean isTrue = true;
    char aChar = 'a';
    
    byte aByte = 127;
    short aShort = 10;
    int aInt = 8;
    long aLong = 10000000000000000L;
    
    float aFloat = 1.5f;
    double aDouble = 1.5;
    
    int b = (int) aDouble;
    
    String s = "Hello";
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("HEre is some text");
        
        int hereIsAVariableName = 10;
        
        byte ab = 5;
        int cd = ab;
        
        int a = (int) Math.round(1.5);
        String b = "Hello" + " World!";
        System.out.println(b);
        String c = null;
        String d = "";
        
        String x = "Kyle";
        String y = x.concat("Rudy");
        
        int f = 1 + 3 - 4 * 5 / 6 % 7;
        
        f++;
        f--;
        ++f;
        --f;
        
        f += 5;
        
        // Line commment
        /*
        Here
        is a 
        block
        comment
        */
        
        double h = ControlFlowStuff.PI;
        
    }
}
