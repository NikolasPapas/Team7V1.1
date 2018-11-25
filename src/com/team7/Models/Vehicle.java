package com.team7.Models;



/**
 * @author NikolaosPapazian
 * @version 1.0
 * Vehicle
 * mast have ID,LicensePlate,Insurance
 */
public class Vehicle implements Comparable<Vehicle>{
    private String vehID;
    private String vehLicensePlate;
    private String ownerID;
    private String insurID;
    private Insurance vehInsurance;

    public String getVehID() {
        return vehID;
    }

    public void setVehID(String vehID) {
        this.vehID = vehID;
    }

    public String getVehLicensePlate() {
        return vehLicensePlate;
    }

    public void setVehLicensePlate(String vehLicensePlate) {
        this.vehLicensePlate = vehLicensePlate;
    }

    public Insurance getVehInsurance() {
        return vehInsurance;
    }

    public void setVehInsurance(Insurance vehInsurance) {
        this.vehInsurance = vehInsurance;
    }

    @Override
    public String toString(){
        return "["+"vehicle_ID:"+vehID+"]";
    }

    @Override
    public int compareTo(Vehicle o) {
        if(toString().equals(o.toString())){
            return 1;
        }

        //TODO: the correct comparing method
        // return -X if is down from this
        // return 0 if is the same
        //return +x if is up from this
        return 0;
    }
}
