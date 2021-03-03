/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

/**
 *
 * @author Andres Rios
 */
public class RepositoryFactory {
    
    private static RepositoryFactory instance;
    
    //Default constructor
    private RepositoryFactory(){
        
    }
    
    //Returns the instance value
    public static RepositoryFactory getInstance(){
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }
    
    //Returns a repository of vehicles
    public IVehicleRepository getRepository(String type){
        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }

        return result;
    }
}
