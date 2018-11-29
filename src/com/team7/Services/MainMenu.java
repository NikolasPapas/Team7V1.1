package com.team7.Services;

import com.team7.Controllers.VehicleController;
import com.team7.Models.Owner;
import com.team7.Models.Vehicle;
import java.util.*;

public class MainMenu {
    /**
     * @author Vagelis Giannakosian
     * method  Main menu()
     * Creates the main menu and through a switch it lets the user decide
     * which of the available functions to choose
     */
    public void mainMenu(){
       boolean finished = false;

        while (!finished) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("---- Select Functionality to perform:");
            System.out.println("1. Vehicle Insurance status");
            System.out.println("2. Forecoming Expiries");
            System.out.println("3. Expiries by plate");
            System.out.println("4. Fine calculation per owner");
            System.out.println("5. Exit");
            System.out.print("Choose:");
            int choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    function1();
                    break;
                case 2:
                    function2();
                    break;
                case 3:
                    function3();
                    break;
                case 4:
                    function4();
                    break;
                case 5:
                    finished = closemenu();
                    break;
                default:
                    System.out.println("Please select one of the given options");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input, please select one of the given options.");
        }

    }

}

    /**
     *
     * Function 1
     */

    private void function1() {
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

    private void function2() {
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

    private void function3() {
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

    private void function4() {

        IoHandle imp = new IoHandle();
        imp.dataImport();
    }

    /**@author Vagelis Giannakosian
     * Function Closemenu
     * returns true so as the programm to be ended
     */

    private boolean closemenu() {
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
