package com.team7.Models;

import java.util.UUID;

/**
 * @author NikolaosPapazian
 * @version 1.0
 * Vehicle
 * mast have ID,LicensePlate,Insurance
 */
public class Vehicle{
    private UUID vehID;
    private String vehLicensePlate;
    private UUID ownerID;
    private UUID insurID;
    private Insurance vehInsurance;

    public UUID getVehID() {
        return vehID;
    }

    public void setVehID(UUID vehID) {
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
}
