package com.team7.Controllers;



import com.team7.DataSave.SingletonDataSave;
import com.team7.Models.Vehicle;

import java.util.ArrayList;
import java.util.List;


/**
 * @author NikolaosPapazian
 * @version 1.0
 */
public class VehicleController {
    private List<Vehicle> vehicleList;
    private SingletonDataSave singletonClass;


    /**
     * Constructor
     * @version 1.0
     */
    public VehicleController() {
        singletonClass = SingletonDataSave.getInstance();
    }

    /**
     * Constructor
     * @version 1.0
     * @param vehicleList
     */
    public VehicleController(ArrayList<Vehicle> vehicleList) {
        singletonClass = SingletonDataSave.getInstance();
        singletonClass.setSingletonVehicle(vehicleList);
        this.vehicleList = vehicleList;
    }

    /**
     * @version 1.0
     * @return ArrayList<Vehicle>
     */
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    /**
     * get specific vehicle with ID
     * @version 1.0
     * @param vehID
     * @return Vehicle | null
     */
    public Vehicle getVehicleID(String vehID) {
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
     * @param vehicleList
     */
    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        singletonClass.setSingletonVehicle(vehicleList);

        this.vehicleList = vehicleList;
    }

}
