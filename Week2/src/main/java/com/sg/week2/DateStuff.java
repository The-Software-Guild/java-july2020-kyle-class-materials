package com.sg.week2;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Kyle David Rudy
 */
public class DateStuff {
    public static void main(String[] args) {
        Date d = new Date(2020, 7, 1); //3920, 8, 1
        d.setHours(10);
        
        
        
        Calendar c = GregorianCalendar.getInstance();
        c.set(2020, 7, 1);
        
        
        LocalDate ld = LocalDate.now();
        
        ZonedDateTime zdt = ZonedDateTime.now();
        
        
    }
}
