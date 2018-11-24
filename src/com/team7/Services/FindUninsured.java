package com.team7.Services;


import com.team7.Models.*;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author NikolaosPapazian
 * @version 1.0
 */
public class FindUninsured {

    private ArrayList<Vehicle>  UninsuredVehicles;

    public FindUninsured(ArrayList<Vehicle> UninsuredVehicles) {
        UninsuredVehicles = UninsuredVehicles;


    }

    /**
     * isUnsuredNow
     * @param Insurance
     * @return boolean (if Insurance is Insured)
     */
    private boolean isUnsuredNow (Insurance Insurance){
        Calendar calendar = Calendar.getInstance();
        if( Insurance.getInsurTo().before(calendar.getTime()) ){
            return true;
        }
        return false;
    }

    /**
     * isUnsuredInDate
     * @param Insurance
     * @param x
     * @return boolean if Insurance is Insured in the x days after
     */
    private boolean isUnsuredInDate (Insurance Insurance ,int x){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, x);
        if( Insurance.getInsurTo().before(calendar.getTime())){
            return true;
    }
        return false;
    }
}
