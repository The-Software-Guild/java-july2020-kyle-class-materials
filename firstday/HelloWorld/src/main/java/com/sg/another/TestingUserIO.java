package com.sg.another;

import com.sg.io.UserIO;
import com.sg.io.UserIOConsoleImpl;

/**
 *
 * @author Kyle David Rudy
 */
public class TestingUserIO {
    
    int a = 10;
    
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        
        String name = io.readString("What is your name?");
        int age = io.readInt("What is your age?");
        int number = io.readInt("Choose a number 1-10", 1, 10);
        
        TestingUserIO tuIO = new TestingUserIO();
        tuIO.printHello();
        TestingUserIO.printGoodBye();
    }
    
    
    private void printHello() {
        System.out.println("Hello");
    }
    
    public static void printGoodBye() {
//        System.out.println("Good bye " + a);
    }
}
