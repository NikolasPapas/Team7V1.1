package com.team7.Services;


import com.team7.Controllers.InsuranceController;
import com.team7.DataSave.SingletonDataSave;
import com.team7.Models.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author NikolaosPapazian
 * @version 1.0
 * that class need Constructor to Work properly
 */
public class FindUninsured {
    private SingletonDataSave singletonClass;

    private List<Vehicle> UninsuredVehicles;
    private List<Insurance> UninsuredInsurances;

    /**
     * We need the constructor to initialise tha SingletonDataSave
     */
    public FindUninsured() {
        singletonClass = SingletonDataSave.getInstance();
        /*
        UninsuredVehicles =singletonClass.getSingletonVehicle();
        UninsuredInsurances =singletonClass.getSingletonInsurance();
        */
    }

    /**
     * FindAllUninsuredVehicleID
     * You can call that method an return to you All Uninsured Insurances
     * take all the values from SingletonDataSave Class
     * @return AllUninsuredVehicleID
     */
    public ArrayList FindAllUninsuredVehicleID (){
        ArrayList AllUninsured = new ArrayList();
        for (Insurance ins:singletonClass.getSingletonInsurance()) {
            if(isUninsuredNow(ins)){
                AllUninsured.add(ins);
            }
        }
        return AllUninsured;
    }

    /**
     * isUninsuredNow
     * that method get the Insurence and return true if is Uninsured
     * @param insurance
     * @return boolean (if Insurance is Insured)
     */
    public boolean isUninsuredNow (Insurance insurance){
        Calendar calendar = Calendar.getInstance();
        if( insurance.getInsuranceTo().before(calendar.getTime()) ){
            return true;
        }
        return false;
    }

    /**
     * isUninsuredInDate
     * that method get int for Days and return a ArrayList
     * with the Insurance hou ends to x days     *
     * @param Insurance
     * @param x
     * @return ArrayList
     */
    public ArrayList isUninsureInDate (Insurance Insurance ,int x){
        //TODO: make the x days to Experied Isurance Vehicles
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, x);
        ArrayList AllUninsured = new ArrayList<InsuranceController>();

        for (Insurance ins:singletonClass.getSingletonInsurance()) {
            if( ins.getInsuranceTo().before(calendar.getTime())){
                AllUninsured.add(ins);
            }
        }
        return AllUninsured;
    }
}
