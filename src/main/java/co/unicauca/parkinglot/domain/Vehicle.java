/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.domain;

/**
 *
 * @author Andres Rios
 */
public class Vehicle {
 
    private String plate;
    private TypeEnum type;
    
    //Default consructor for Vehicles
    public Vehicle(){
        
    }
    
    //Constructor with parametters for Vehicles
    public Vehicle(String plate, TypeEnum type){
        this.plate = plate;
        this.type = type;
    }
    
    //Returns a Vehicles plate
    public String getPlate(){
        return this.plate;
    }
    
    //Returns a Vehicles type
    public TypeEnum getType(){
        return this.type;
    }
    
    //chages a Vehicles plate
    public void setPlate(String plate){
        this.plate = plate;
    }
    
    //chages a Vehicles type
    public void setType(TypeEnum type){
        this.type = type;
    }
    
    //Returns a Vehicle object as a String
    @Override
    public String toString(){
        return "Vehicle{" + "plate=" + this.plate + ", type=" + this.type + "}";
    }
}
