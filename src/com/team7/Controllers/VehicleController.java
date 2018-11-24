package com.team7.Controllers;



import com.team7.Models.Vehicle;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author NikolaosPapazian
 * @version 1.0
 */
public class VehicleController {
    private ArrayList<Vehicle> vehicleList;

    /**
     * Constructor
     * @version 1.0
     * @since 22/11/18
     * @param vehicleList
     */
    public VehicleController(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    /**
     * @version 1.0
     * @since 22/11/18
     * @return ArrayList<Vehicle>
     */
    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    /**
     * get specific vehicle with ID
     * @version 1.0
     * @since 22/11/18
     * @param vehID
     * @return Vehicle | null
     */
    public Vehicle getVehicleID(UUID vehID) {
        for (Vehicle veh:vehicleList) {
            if(vehID.equals(veh.getVehID())){
                return veh;
            }
        }
        return null;
    }

    /**
     * get specific vehicle with LicensePlate
     * @version 1.0
     * @since 22/11/18
     * @param plate
     * @return Vehicle | null
     */
    public Vehicle getVehiclePlate(String plate) {
        for (Vehicle veh:vehicleList) {
            if(plate.equals(veh.getVehLicensePlate())){
                return veh;
            }
        }
        return null;
    }

    /**
     * set a new List of Vehicles
     * @version 1.0
     * @since 22/11/18
     * @param vehicleList
     */
    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
