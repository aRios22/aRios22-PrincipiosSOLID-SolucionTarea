/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.infra;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 *
 * @author Andres Rios
 */
public class Utilities {
    
    //Returns the hours between to LocalDateTime hour fields. not total hours
    public static long calculateHours(LocalDateTime input, LocalDateTime output){
        if(validateTime(input, output)){
            long hours;
            hours = Math.abs(input.getHour() - output.getHour());
            return hours;
        }
        else{
            return 0;
        }
    }
    
    //Returns the minutes between to LocalDateTime minute fields. not total minutes
    public static long calculateMinutes(LocalDateTime input, LocalDateTime output){
        if(validateTime(input, output)){
            long minutes;
            minutes = Math.abs(input.getMinute() - output.getMinute());
            return minutes;
        }
        else{
            return 0;
        }
    }
    
    //Returns the days between to LocalDateTime say fields. not total time
     public static long calculateDays(LocalDateTime input, LocalDateTime output){
        if(validateTime(input, output)){
            long days;
            days = Math.abs(output.getDayOfMonth() - input.getDayOfMonth());
            return days;
        }
        else{
            return 0;
        }
    }
    
    //Validate the integrity of input and ouput dates 
    public static boolean validateTime(LocalDateTime input, LocalDateTime output){
        return input.isBefore(output);
    }
    
    //Aproximates long values to their colest upper hundred
    public static long aproxValue(long value){
        double doubleValue = (double)value;
        doubleValue /= 100;
        doubleValue = Math.ceil(doubleValue);
        doubleValue *= 100;
        return (long)doubleValue;
    }
    
    //Randomly chooses a Truc that can get free Parking
    public static boolean free(){
        Random random = new Random();
        int low = 0;
        int high = 1000;
        int result = random.nextInt(high - low) + low;
        return result == 1000;
    }
    
}
