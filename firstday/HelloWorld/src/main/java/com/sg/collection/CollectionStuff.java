package com.sg.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author Kyle David Rudy
 */
public class CollectionStuff {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Kyle");
        stringList.add(0, "Rudy");
        stringList.get(0);
        stringList.remove(0);
        stringList.clear();
        stringList.contains("Kyle");
        for(String s : stringList) {
            
        }
        
        for(int i = 0;i<stringList.size();i++) {
            String s = stringList.get(i);
        }
        
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Kyle");
        stringSet.add("Kyle");
        for(String s : stringSet) {
            
        }
        
        Map<String, Integer> stringMap = new HashMap<>();
        stringMap.put("Kyle", 1);
        
        
        int a = stringMap.get("Kyle");
        stringMap.put("Kyle", 2);
        stringMap.put(null, 3); 
       
        
    }
}
