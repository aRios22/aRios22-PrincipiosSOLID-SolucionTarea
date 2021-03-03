/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

import java.time.LocalDateTime;

/**
 *
 * @author Andres Rios
 */
public interface IParkingCost {
    
  public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
    
}
