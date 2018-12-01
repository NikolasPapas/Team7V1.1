package com.team7.Services;


import com.team7.Controllers.InsuranceController;
import com.team7.DataSave.SingletonDataSave;
import com.team7.Models.*;

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

    /**
     * Constructor
     * We need the constructor to initialise tha SingletonDataSave
     */
    public FindUninsured() {
        singletonClass = SingletonDataSave.getInstance();
    }

    /**
     * FindAllUninsuredVehicleID
     * You can call that method an return to you All Uninsured Insurances
     * take all the values from SingletonDataSave Class
     * @return AllUninsuredVehicleID
     */
    public List<Insurance> FindAllUninsuredInsuranceID (){
        List<Insurance> AllUninsured = new ArrayList<>();
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
        return insurance.getInsuranceTo().after(calendar.getTime());
    }

    /**
     * isUninsuredInDate
     * that method get int for Days and return a ArrayList
     * with the Insurance hou ends to x days
     * @param x
     * @return ArrayList
     */
    public List<Insurance> isUninsuredInDate (int x){
        List<Insurance> AllUninsured = new ArrayList<>();

        for (Insurance ins:singletonClass.getSingletonInsurance()) {
            if( !isOneUninsuredInDate(ins,x)){
                AllUninsured.add(ins);
            }
        }
        return AllUninsured;
    }

    /**
     * isUninsuredInDate
     * that method get int for Days and return a ArrayList
     * with the Insurance hou ends to x days
     * @param x
     * @return ArrayList
     */
    public Boolean isOneUninsuredInDate (Insurance insurance, int x){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, x);
        List AllUninsured = new ArrayList<InsuranceController>();
        if( insurance.getInsuranceTo().after(cal.getTime())){
            return true;
        }
        return false;
    }
}
