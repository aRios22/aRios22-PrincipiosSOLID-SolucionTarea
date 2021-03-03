/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain.service;

import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.CarParkingCost;
import co.unicauca.parkinglot.domain.MotoParkingCost;
import co.unicauca.parkinglot.domain.TruckParkingCost;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Rios
 */
public class Service {
    
    private co.unicauca.parkinglot.access.IVehicleRepository repository;
    
    //Gives a value to the local repository
    public Service(IVehicleRepository repo){
        repository = repo;
    }
    
    //Calculates parking cost deppending on the type of vehicle given
    public long calculateParkingCost(Vehicle veh, LocalDateTime input,LocalDateTime output){
        TypeEnum varType = veh.getType();
        
        
            switch(varType.name()){
 
                case "MOTO":
                    MotoParkingCost varMotoParking = new MotoParkingCost();
                    return varMotoParking.calculateCost(veh, input, output);
                
            
                case "CAR":
                    CarParkingCost varCarParking = new CarParkingCost();
                    return varCarParking.calculateCost(veh, input, output);
                
            
                case "TRUCK":
                    TruckParkingCost varTruckParking = new TruckParkingCost();
                    return varTruckParking.calculateCost(veh, input, output);  
                
                
                default: 
                    return 0;
                
            }
            
    }
    
    //Saves vehicle in the repository
    public boolean saveVehicle(Vehicle veh){
        
        if (veh == null || veh.getPlate().isBlank() || veh.getType().name().isBlank()) {
            return false;
        }
        repository.save(veh);
        return true;
    }
    
    //Lists all the saved Vehicles on repository.
    public List<Vehicle> listVehicles(){
        List<Vehicle> vehicles;
        vehicles = repository.list();
        return vehicles;
    }
}
