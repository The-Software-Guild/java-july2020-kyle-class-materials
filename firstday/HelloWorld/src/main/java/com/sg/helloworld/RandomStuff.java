package com.sg.helloworld;

import java.util.Random;

/**
 *
 * @author Kyle David Rudy
 */
public class RandomStuff {
    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0;i<10;i++) {
            System.out.println((int) (Math.random()*10) );
        }
    }
}
