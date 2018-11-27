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

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getInsurID() {
        return insurID;
    }

    public void setInsurID(String insurID) {
        this.insurID = insurID;
    }

    @Override
    public String toString(){
        return "["+"vehicle_ID:"+vehID+"]";
    }

    @Override
    public int compareTo(Vehicle o) {
        return vehLicensePlate.compareTo(o.vehLicensePlate);
    

    }
}
