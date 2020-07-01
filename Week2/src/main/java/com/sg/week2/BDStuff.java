package com.sg.week2;

import java.math.BigDecimal;

/**
 *
 * @author Kyle David Rudy
 */
public class BDStuff {
    public static void main(String[] args) {
        float f = 0.01f;
        
        for(int i = 0;i<10;i++) {
            f += 0.01f;
            System.out.println(f);
        }
        System.out.println("");
        
        BigDecimal bd = new BigDecimal("0.01");
        for(int i = 0;i<10; i++) {
            bd = bd.add(new BigDecimal("0.01"));
            
            System.out.println(bd.setScale(4));            
        }
    }
}
