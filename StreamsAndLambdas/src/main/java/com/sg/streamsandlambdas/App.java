/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.streamsandlambdas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author kylerudy
 */
public class App {
    public static void main(String[] args) {
        List<Person> persons = loadPersons();
        System.out.println("Total People: " + persons.size());
        
//        persons.stream()
//                .filter(p -> p.getLastName().startsWith("S") && p.getFirstName().startsWith("R"))
//                .forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastName()));
        
//        List<Person> people = persons.stream()
//                .peek(p -> p.setFirstName("Bob"))
//                .collect(Collectors.toList());
//        
//        for(Person p : people) {
//            System.out.println(p.getFirstName() + " " + p.getLastName());
//        }
//
//        persons.stream() //Stream<Person>
//                .map(p -> p.getCar()) //Stream<String>
//                .distinct()
//                .forEach(c -> System.out.println(c));

        Map<String, List<Person>> countryPeople = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getCountry()));
        
        countryPeople.forEach((k, v) -> { 
            System.out.println(k + " - " + v.size());
                });
        
//        for(String country : countryPeople.keySet()) {
//            System.out.println(country + " - " + countryPeople.get(country).size());
//        }

        persons.stream()
                .filter(App::isRussia)
                .map(Person::getCountry)
                .collect(Collectors.toList());
                
                
    }
    
    private static boolean isRussia(Person p) {
        return "Russia".equals(p.getCountry());
    }
    

    private static List<Person> loadPersons() {
        List<Person> persons = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("MOCK_DATA.csv"));
            sc.nextLine(); //Eat the header
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                
                Person person = new Person();
                person.setId(Integer.parseInt(parts[0]));
                person.setFirstName(parts[1]);
                person.setLastName(parts[2]);
                person.setEmail(parts[3]);
                person.setCountry(parts[4]);
                person.setCompany(parts[5]);
                person.setCar(parts[6]);
                person.setSales(Double.parseDouble(parts[7]));
                
                persons.add(person);
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Can't Load File");
            System.out.println(ex.getMessage());
        }
        return persons;
    }
}
