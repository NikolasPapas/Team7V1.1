package com.team7.DataSave;


import com.team7.Models.*;

import java.util.List;

/**
 * That is a Singleton Class
 * Save the values from our data and you can use them from anywhere any time
 * You mast input your class only that:
 *
 * On start of the class
 *      "private SingletonClass singletonClass;"
 * On Creation on your class EX: in you Constructor
 *      "singletonClass = SingletonClass.getInstance();"
 * And you can get values like this.
 *      "singletonClass.getSingletonVehicle();"
 *
 * @author NikolasPapazian
 * @version 1.0
 */
public class SingletonDataSave {
    private static SingletonDataSave ourInstance = new SingletonDataSave();

    //Hear we define tha data we stored
    private List<Vehicle> singletonVehicle = null;
    private List<Owner> singletonOwner = null;
    private List<Insurance> singletonInsurance = null;

    public static SingletonDataSave getInstance() {
        if(ourInstance == null){
            ourInstance = new SingletonDataSave();
        }
        return ourInstance;
    }

    private SingletonDataSave() {
    }


    public List<Vehicle> getSingletonVehicle() {
        return singletonVehicle;
    }

    public void setSingletonVehicle(List<Vehicle> singletonVehicle) {
        this.singletonVehicle = singletonVehicle;
    }

    public void setSingletonOneVehicle(Vehicle singletonVehicle) {
        this.singletonVehicle.add(singletonVehicle);
    }

    public List<Owner> getSingletonOwner() {
        return singletonOwner;
    }

    public void setSingletonOwner(List<Owner> singletonOwner) {
        this.singletonOwner = singletonOwner;
    }
    public void setSingletonOneOwner(Owner singletonOwner) {
        this.singletonOwner.add(singletonOwner);
    }

    public List<Insurance> getSingletonInsurance() {
        return singletonInsurance;
    }

    public void setSingletonInsurance(List<Insurance> singletonInsurance) {
        this.singletonInsurance = singletonInsurance;
    }
    
    public void setSingletonOneInsurance(Insurance singletonInsurance) {
        this.singletonInsurance.add(singletonInsurance);
    }

}
