package com.sg.another;

import java.util.Scanner;

/**
 *
 * @author Kyle David Rudy
 */
public class ControlFlowStuff {
    
    public static final double PI = 3.14;
    final String FIRST_NAME = "Kyle";
    
    public static void main(String[] args) {
        int a = 100;
        int b = 51;
        
        doSomeStuff(a);
        
        while( a != 100) {
            System.out.println("Running while");
        }
                
        int num = getNumberFromUser();
        
        for(int i = 0;i<num; i++) {
            System.out.println(i);
        }
        
        int num2 = getNumberFromUser();
        
        for(int i = 0;i<num; i++) {
            System.out.println(i);
        }
        
//        System.out.println(a);
    }
    
    private static void doSomeStuff(int a) {
        switch(a) {
            case 9:
                System.out.println("It's 9");
                break;
            case 10:
                System.out.println("It's 10!");
                break;
            case 15:
                System.out.println("It's 15!");
                break;
            case 20:
                System.out.println("It's 20");
                break;
            default:
                System.out.println("It's not 10!");
        }
    }
    
    public static int getNumberFromUser() {
        Scanner sc = new Scanner(System.in);
        int num = -1;
        do {
            System.out.println("Enter a number 1-20");
            num = Integer.parseInt(sc.nextLine());
        } while( num < 1 || num > 20);
        return num;
    }
}
