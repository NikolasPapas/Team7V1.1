package com.team7;

import com.team7.Controllers.VehicleController;
import com.team7.Models.Owner;
import com.team7.Models.Vehicle;
import com.team7.Services.IoHandle;
import com.team7.Services.VehicleSearch;
import com.team7.Controllers.OwnerController;

import java.util.*;

public class Functions {

    /**
     *
     * Function 1
     */

    public void function1() {
        String choice;
        boolean finished;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Give Vehicle's plate Number: ");
            choice = keyboard.nextLine();
            finished = verifyPlate(choice.toUpperCase());
        }
        while (!finished);
        IoHandle imp = new IoHandle();
        imp.dataImport();
        find(choice);
    }

    /**
     * Function 2
     */

    public void function2() {
        int choice;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Check Which plates expire in X days");
        choice = keyboard.nextInt();
        IoHandle imp = new IoHandle();
        imp.dataImport();
        printUninsuredVehicle(choice);
    }

    /**
     * @author Vagelis Giannakosian
     * Function 3
     * Instantiates an Arraylist<string> called str
     * Establishes connection with the Db through dataImport() and sends data to Singletonclass
     * The method FindOwnerVehicleInsuranseID() returns the sorted map of the uninsured vehicles
     * each of the map's Vehicle's License Plate is added to the Arraylist str
     * the Arraylist str is sent to the dataExport() to be printed
     */

    public void function3() {
        ArrayList<String> str = new ArrayList<>();
        IoHandle imp = new IoHandle();
        imp.dataImport();
        VehicleSearch vehSearch =new VehicleSearch();

        Map<Vehicle,Owner> uninsuredArrayList = vehSearch.FindOwnerVehicleInsuranseID();

        for (Vehicle veh2:uninsuredArrayList.keySet()) {
            str.add(veh2.getVehLicensePlate());
        }
        IoHandle exp = new IoHandle();
        exp.dataExport(str);
    }

    /**
     * Function 4
     */

    public void function4() {

        ArrayList<String> str = new ArrayList<>();
        IoHandle imp = new IoHandle();
        imp.dataImport();
        int timesOfName=0;
        boolean findName= false;
        try{
            System.out.println("EXAMPLE: ");
            System.out.println("Give the owner: \033[34mGREG\033[0m");
            System.out.println("the ticket: \033[34m50,4\033[0m  \033[31mNOT 50.4\033[0m");
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Give the owner: ");
            String choice = keyboard.nextLine();
            System.out.println("the ticket: ");
            //keyboard.useLocale(Locale.US); If want to trying like that 50.4
            double ticket=keyboard.nextDouble();

            VehicleSearch unis = new VehicleSearch();
            OwnerController sin= new OwnerController();

            for (Owner onw : sin.getOwnerList()) {
                if (onw.getOwnerName().equals(choice.toUpperCase())) {
                    Map<Vehicle, Owner> map = unis.FindOwnerVehicleInsuranseID();
                    for (Owner value : map.values()) {
                        if (value.getOwnerName().equals(choice.toUpperCase())) {
                            value.setTicketValue(ticket);
                            timesOfName++;
                            findName = true;
                        }
                    }
                }
            }
            if (findName) {
                str.add(choice + " should pay " + (timesOfName * ticket));
                IoHandle exp = new IoHandle();
                exp.dataExport(str);
            }else{
                System.out.println("No such Name in Database");
            }

        }catch (InputMismatchException e) {
            System.out.println("Invalid Input, please give the right input next time");
        }
    }

    /**@author Vagelis Giannakosian
     * Function Closemenu
     * returns true so as the programm to be ended
     */

    public boolean closemenu() {
        return true;
    }

    /**@author Vagelis Giannakosian
     *  Method dataImport()
     *  It asks the user to choose between file and database as the source of tha data
     *  if the user chooses '1', method toFile() is called
     *  if the user chooses '2', method toDb() is called
     */


    /**
     * Method for f1 Validation
     */
    private boolean verifyPlate(String plate) {
        if (plate.matches("[A-Z]{3}[-]{1}[0-9]{4}")) {
            return true;

        } else {
            System.out.println("Invalid input format!");
            return false;
        }
    }


    /** Method tha checks if a car is uninsured*/
    private void find(String choice) {
        ArrayList<String> str = new ArrayList<>();
        boolean unisured = false;
        VehicleSearch unis = new VehicleSearch();
        ArrayList<Vehicle> ola = unis.FindAllUninsuredVehicleID();

        for (Vehicle o : ola) {
            if (o.getVehLicensePlate().equals(choice.toUpperCase())) {
                str.add(choice.toUpperCase() + " is uninsured");
                IoHandle exp = new IoHandle();
                exp.dataExport(str);
                unisured = true;
            }
        }
        if (!unisured) {
            VehicleController insur = new VehicleController();
            List<Vehicle> all = insur.getVehicleList();
            for (Vehicle o : all) {
                if (o.getVehLicensePlate().equals(choice.toUpperCase())) {
                    str.add(choice.toUpperCase() + " is insured");
                    IoHandle exp = new IoHandle();
                    exp.dataExport(str);
                    unisured = true;
                }
            }
        }
        if (!unisured) {
            str.add(choice.toUpperCase() + " is not in Database");
            IoHandle exp = new IoHandle();
            exp.dataExport(str);
        }
    }

    /**
     * Implementation of function 2
     * */
    private void printUninsuredVehicle(int choice){
        ArrayList <String> str = new ArrayList<>();
        VehicleSearch unis = new VehicleSearch();
        ArrayList<Vehicle> ola = unis.FindAllUninsuredVehicleOnDateID(choice);
        for (Vehicle o :ola) {
            str.add("Vehicle's Plate: "+o.getVehLicensePlate()+" expires at "+o.getVehInsurance().getInsuranceTo());
        }
        IoHandle exp = new IoHandle();
        exp.dataExport(str);

    }

}
