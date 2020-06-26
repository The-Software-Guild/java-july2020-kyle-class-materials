package com.sg.helloworld;

import com.sg.another.ControlFlowStuff;
import java.util.Scanner;


/**
 *
 * @author Kyle David Rudy
 */
public class InputStuff {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Type in your name:");
        String name = sc.nextLine(); //Kyle/n
        
        System.out.println("Your name is " + name);
        
        System.out.println("What is your age?");
        
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Your age is " + age);
        
        System.out.println("What is your kitty's name?");
        String kitty = sc.nextLine(); ///n 
        
        System.out.println(kitty + " is a good kitty");
        
        int num = ControlFlowStuff.getNumberFromUser();
        
    }
}
