/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.access;

import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import co.unicauca.parkinglot.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres Rios
 */
public class VehicleRepository implements IVehicleRepository{
 
    private Connection Connection;
    
    //Starts the database 
    public VehicleRepository(){
        initDataBase();
    }
       
    //Initializes the database an creates the necesary tables
    private void initDataBase(){
        // SQL statement for creating a new table
       String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	plate text PRIMARY KEY,\n"
                + "	type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = Connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //Connects the project to a virtual squiLite database
    public void connect(){
         String url = "jdbc:sqlite::memory:";

        try {
            Connection = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Disconnecs the project from database
    public void disconnect(){
       try {
            if (Connection != null) {
                Connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    //Overrides save on IVehicleRepository. Saves a new vehicle in the database
    @Override
    public boolean save(Vehicle newVehicle) {
        try {
            //Validate product
            if (newVehicle == null || newVehicle.getPlate().isBlank()|| newVehicle.getType().name().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Vehicle ( plate, type ) " + "VALUES ( ?, ? )";
            
            PreparedStatement pstmt = Connection.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setString(2, newVehicle.getType().name());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Overrides list on IVehicleRepository. Lists the saved Vehicles on the database.
    @Override
    public List<Vehicle> list() {
         List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT plate, type FROM Vehicle";
            //this.connect();

            Statement stmt = Connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("plate"));
                TypeEnum enumVal =  TypeEnum.valueOf(rs.getString("type"));
                newVehicle.setType(enumVal);
            
                vehicles.add(newVehicle);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
}

