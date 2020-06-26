package com.sg.another;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public class TestClass {
    public static void main(String[] args) {
        List<Integer[]> frames = new ArrayList<>();        
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{8, 2});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{10, 0});
        frames.add(new Integer[]{8, 1});
        frames.add(new Integer[]{9, 0});
        frames.add(new Integer[]{7, 3});
        frames.add(new Integer[]{6, 3});
        frames.add(new Integer[]{8, 2, 5}); //173
        
//        Integer[] frame = frames.get(0);
//        int ballOne = frame[0]; //8
//        int ballTwo = frame[1]; //2
//        
//        ballOne = frames.get(0)[0];
//        
//        frames.size();
        Integer[] newFrame = {5,6};
        frames.set(1, newFrame);
        
        for(Integer[] frame : frames) {
            System.out.println(frame[0] + "," + frame[1]);
        }
    }
}
