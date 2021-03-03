/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 *
 * @author Andres Rios
 */
public class CarParkingCost implements IParkingCost{

    //Overrides calculateCost of IParkingCost. Calculates parking cost for a Car. 
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        long varValue;
        long hours = Utilities.calculateHours(input, output);
        long minutes = Utilities.calculateMinutes(input, output);
        
        if((hours < 1 && minutes > 0) || (hours == 1 && minutes == 0)){
            varValue = 2000;  
        }
        else if((hours >= 1 && minutes > 0) || (hours > 1 && minutes == 0)){
            int numHours = (int)hours;
            
            varValue =  (2000 + ((numHours - 1) * 1000) + ((minutes * 1000)/60));
        }
        else{
            varValue = 0;//ERROR.
        }
                           
            varValue = Utilities.aproxValue(varValue);
            return varValue;
    }
    
    
   
}
