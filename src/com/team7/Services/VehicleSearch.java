package com.team7.Services;


import com.team7.DataSave.SingletonDataSave;
import com.team7.Models.Insurance;
import com.team7.Models.Owner;
import com.team7.Models.Vehicle;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author NikolaosPapazian
 * @version 1.0
 * that class need Constructor to Work properly
 */
public class VehicleSearch {
    private SingletonDataSave singletonClass;


    /**
     * Constructor
     * We need the constructor to initialise tha SingletonDataSave
     */
    public VehicleSearch() {
        singletonClass = SingletonDataSave.getInstance();
    }

    /**
     * FindAllUninsuredVehicleID
     * scan all Vehicles and scan and find VehicleInsurance
     * if Insurance is Uninsured put Insurance in to Vehicle
     * and put it in The List
     * after that return the List with Uninsured Vehicles
     *
     * @return ArrayList
     */
    public ArrayList FindAllUninsuredVehicleID () {
        ArrayList vehicleList = new ArrayList();
        FindUninsured findUninsured = new FindUninsured();
        for (Vehicle veh:singletonClass.getSingletonVehicle()) {
            for (Insurance ins:singletonClass.getSingletonInsurance()) {
                if(ins.getInsuranceID().equals(veh.getInsurID())){
                    if(!findUninsured.isUninsuredNow(ins)){
                        veh.setVehInsurance(ins);
                        vehicleList.add(veh);
                    }
                }

            }
        }
        return vehicleList;
    }

    /**
     * FindAllUninsuredVehicleOnDateID
     * scan all Vehicles and scan and find VehicleInsurance
     * if Insurance is Uninsured today+XdaysAfter put Insurance in to Vehicle
     * and put it in The List
     * after that return the List with Uninsured Vehicles
     * @return ArrayList
     */
    public ArrayList FindAllUninsuredVehicleOnDateID(int x){
        ArrayList vehicleList = new ArrayList();
        FindUninsured findUninsured = new FindUninsured();
        for (Vehicle veh:singletonClass.getSingletonVehicle()) {
            for (Insurance ins:singletonClass.getSingletonInsurance()) {
                if(ins.getInsuranceID().equals(veh.getInsurID())){
                    if(!findUninsured.isOneUninsuredInDate(ins,x)){
                        veh.setVehInsurance(ins);
                        vehicleList.add(veh);
                    }
                }

            }
        }
        return vehicleList;
    }

    /**
     * FindAllUninsuredVehicleOnDateID
     * scan all Vehicles and scan and find VehicleInsurance
     * if Insurance is Uninsured put Insurance in to Vehicle
     * find VehicleOwner
     * and put it in The treeMap
     * after that return the treeMap with Uninsured Vehicles,Owners
     * @return Map<Vehicle, Owner>
     */
    private Map FindOwnerVehicleInsuranseID(){
        Map<Vehicle, Owner> map = new TreeMap<>();
        FindUninsured findUninsured = new FindUninsured();
        for (Vehicle veh:singletonClass.getSingletonVehicle()) {
            for (Insurance ins:singletonClass.getSingletonInsurance()) {
                if(ins.getInsuranceID().equals(veh.getInsurID())){
                    if(!findUninsured.isUninsuredNow(ins)){
                        for (Owner onw :singletonClass.getSingletonOwner()) {
                            if(onw.getOwnerID().equals(veh.getOwnerID())){
                                veh.setVehInsurance(ins);
                                map.putIfAbsent(veh,onw);
                            }
                        }
                    }
                }

            }
        }
        return map;
    }

}
