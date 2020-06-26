package com.sg.another;

/**
 *
 * @author Kyle David Rudy
 */
public class StuffImpl implements StuffInterface {

    @Override
    public int doMath(int a, int b, int c) {
        return a + b + c;
    }
    
    
    public static void main(String[] args) {
        TestingUserIO tuIO = new TestingUserIO();
        
        TestingUserIO.printGoodBye();
        
    }
}
