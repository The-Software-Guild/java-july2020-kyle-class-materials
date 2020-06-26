package com.sg.another;

import java.util.Scanner;

/**
 *
 * @author Kyle David Rudy
 */
public class ArrayStuff {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] = 10;
        
        a = new int[6];
        
        String[] s = new String[10];
        
        Scanner[] sc = new Scanner[10];
        
        for(int i : a) {
            System.out.println(i);
        }
        
        
        int[][] b = { {1,2,3}, {4,5,6}, {7,8,9,0} };
        
        for(int i = 0;i<b.length; i++) {
            for(int j = 0;j<b[i].length; j++) {
                System.out.println(b[i][j]);
            }
        }
        
    }
}
