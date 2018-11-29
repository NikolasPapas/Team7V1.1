package com.team7;

import com.team7.Controllers.VehicleController;
import com.team7.Services.CsvReader;
import com.team7.Services.CsvWriter;
import com.team7.connect.*;
import com.team7.Models.*;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.team7.Services.VehicleSearch;
import java.util.ArrayList;
import java.util.Map;
public class Main {

    /**
     * @author Vagelis Giannakosian
     * method public static void main() - Main menu
     * Creates the main menu and through a switch, it lets the user decide
     * which of the available functions to choose
     */
    public static void main(String[] args) {
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

    private static void function1() {
        String choice;
        boolean finished;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Give Vehicle's plate Number: ");
            choice = keyboard.nextLine();
            finished = verifyPlate(choice.toUpperCase());
        }
        while (!finished);
        dataImport();
        find(choice);
    }

    /**
     * Function 2
     */

    private static void function2() {
        int choice;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Check Which plates expire in X days");
        choice = keyboard.nextInt();
        dataImport();
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

    private static void function3() {
        ArrayList<String> str = new ArrayList<>();
        dataImport();
        VehicleSearch vehSearch =new VehicleSearch();

        Map<Vehicle,Owner> uninsuredArrayList = vehSearch.FindOwnerVehicleInsuranseID();

        for (Vehicle veh2:uninsuredArrayList.keySet()) {
            str.add(veh2.getVehLicensePlate());
        }
        dataExport(str);
    }

    /**
     * Function 4
     */

    private static void function4() {

        dataImport();
    }

    /**@author Vagelis Giannakosian
     * Function Closemenu
     * returns true so as the programm to be ended
     */

    private static boolean closemenu() {
        return true;
    }

    /**@author Vagelis Giannakosian
     *  Method dataImport()
     *  It asks the user to choose between file and database as the source of tha data
     *  if the user chooses '1', method toFile() is called
     *  if the user chooses '2', method toDb() is called
     */

    private static void dataImport() {
        boolean finished = false;
        do {
            try {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("---- Enter import source:");
                System.out.println("1. From File");
                System.out.println("2. From Data Base");
                int choice = keyboard.nextInt();
                if (choice == 1) {
                    toFile();
                    finished = true;
                } else if (choice == 2) {
                    toDb();
                    finished = true;
                } else {
                    System.out.println("Invalid Input, choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, please select one of the given options.");
            }
        } while (!finished);
    }

    /**@author Vagelis Giannakosian
     * Data import from File
     * instantiates a new object of CsvReader
     * and calls the loadRecord() method
     */

    private static void toFile() {
        CsvReader reader = new CsvReader();
        reader.loadRecord();
    }

    /**@author Vagelis Giannakosian
     * Data import from Db
     * instantiates a new object of Sqlconnection
     * and calls the connect() method
     */
    private static void toDb() {
        SqlConnection sql = new SqlConnection();
        sql.connect();
    }

    /**
     * Method for f1 Validation
     */
    private static boolean verifyPlate(String plate) {
        if (plate.matches("[A-Z]{3}[-]{1}[0-9]{4}")) {
            return true;

        } else {
            System.out.println("Invalid input format!");
            return false;
        }
    }


    /** Method tha checks if a car is uninsured*/
    private static void find(String choice) {
        ArrayList<String> str = new ArrayList<>();
        boolean unisured = false;
        VehicleSearch unis = new VehicleSearch();
        ArrayList<Vehicle> ola = unis.FindAllUninsuredVehicleID();

        for (Vehicle o : ola) {
            if (o.getVehLicensePlate().equals(choice.toUpperCase())) {
                str.add(choice.toUpperCase() + " is uninsured");
                dataExport(str);
                unisured = true;
            }
        }
        if (!unisured) {
            VehicleController insur = new VehicleController();
            List<Vehicle> all = insur.getVehicleList();
            for (Vehicle o : all) {
                if (o.getVehLicensePlate().equals(choice.toUpperCase())) {
                    str.add(choice.toUpperCase() + " is insured");
                    dataExport(str);
                    unisured = true;
                }
            }
        }
        if (!unisured) {
            str.add(choice.toUpperCase() + " is not in Database");
            dataExport(str);
        }
    }
        /**@author Vagelis Giannakosian
         * method dataExport()
         * Takes an argument of Arraylist<string> list
         * lets the user choose where to print the requested data
         * if he chooses '1', the saveRecord(list) is called
         * if he chooses '2', the list of data is printed to the console
         * */

    private static void dataExport(ArrayList<String> list) {
        boolean finished=false;
        int choice;
        do {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("---- Select Export source:");
            System.out.println("1. To File");
            System.out.println("2. To Console");
            choice = keyboard.nextInt();
            if (choice == 1) {
                CsvWriter writer = new CsvWriter();
                writer.saveRecord(list);
                finished = true;
            } else if (choice == 2) {
                for (String str:list) {
                    System.out.println(str);

                }finished = true;
            } else {
                System.out.println("Invalid Input, choose again.");
            }
            }while(!finished);

        }

    private static void printUninsuredVehicle(int choice){
        ArrayList <String> str = new ArrayList<>();
        VehicleSearch unis = new VehicleSearch();
        //Boolean unisured = false;
        ArrayList<Vehicle> ola = unis.FindAllUninsuredVehicleOnDateID(choice);
        for (Vehicle o :ola) {
            str.add("Vehicle's Plate: "+o.getVehLicensePlate()+" expires at "+o.getVehInsurance().getInsuranceTo());
        }
        dataExport(str);

    }


}
