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
public class MotoParkingCost implements IParkingCost{

    //Overrides calculateCost of IParkingCost. Calculates parking cost for a Motorcycle.
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        
        long varValue;
        long hours = Utilities.calculateHours(input, output);
        long minutes = Utilities.calculateMinutes(input, output);
        
        if((hours < 1 && minutes > 0) || (hours == 1 && minutes == 0)){
            varValue = 1000;  
        }
        else if((hours >= 1 && minutes > 0) || (hours > 1 && minutes == 0)){
            int numHours = (int)hours;
            
            varValue =  (1000 + ((numHours - 1) * 500) + ((minutes * 500)/60));
        }
        else{
            varValue = 0;//ERROR.
        }
                           
            varValue = Utilities.aproxValue(varValue);
            return varValue;
    }
       
    
}
