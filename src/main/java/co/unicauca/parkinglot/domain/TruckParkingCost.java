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
public class TruckParkingCost implements IParkingCost {

    //Overrides calculateCost of IParkingCost. Calculates parking cost for a Truck.
    @Override
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
        if(!Utilities.free()){    
            long varValue;
            long hours = Utilities.calculateHours(input, output);
            long minutes = Utilities.calculateMinutes(input, output);
            long days = Utilities.calculateDays(input, output);
            if((days == 0 && hours == 12 && minutes ==0) || (days == 0 && hours < 12 && minutes >= 0)){
                varValue = 10000;
            }
            else if(days == 0 && hours >= 12 && minutes >= 0 && hours < 24 || days == 1 && hours == 0 && minutes == 0){
                varValue = 15000; 
            }
            else if(days > 0){
                              
                varValue = ((15000 * days) + (((hours) * 15000)/24));
            }
            else{
                varValue = 0;//ERROR
            }
        
            varValue = Utilities.aproxValue(varValue);
            return varValue;
        }
        else{
            return 0;
        }
    }
 
    
}
