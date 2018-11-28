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
     * Main menu
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
        System.out.println(choice);
        dataImport();
        find(choice);
        List<Vehicle> veh;
        VehicleController vehcontrol = new VehicleController();
        veh = vehcontrol.getVehicleList();
        System.out.println(veh.get(0).getVehLicensePlate());
    }

    /**
     * Function 2
     */

    private static void function2() {
        //CsvWriter writer = new CsvWriter();
        //writer.saveRecord();
        //dataImport();
    }

    /**
     * Function 3
     */

    private static void function3() {
        ArrayList<String> str = new ArrayList<>();
        dataImport();
        System.out.println("3anagurisa");
        VehicleSearch vehSearch =new VehicleSearch();

        Map<Vehicle,Owner> uninsuredArrayList = vehSearch.FindOwnerVehicleInsuranseID();

        for (Vehicle veh2:uninsuredArrayList.keySet()) {
            str.add(veh2.getVehLicensePlate());
            System.out.println(veh2.getVehLicensePlate());
        }
        dataExport(str);
        //System.out.println(str);
    }

    /**
     * Function 4
     */

    private static void function4() {

        dataImport();
    }

    /**
     * Function Closemenu
     */

    private static boolean closemenu() {
        return true;
    }

    /**
     * IO connection
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

    /**
     * IO to File
     */

    private static void toFile() {
        CsvReader reader = new CsvReader();
        reader.loadRecord();
    }

    /**
     * IO to Db
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
        Boolean unisured = false;
        VehicleSearch unis = new VehicleSearch();
        ArrayList<Vehicle> ola = unis.FindAllUninsuredVehicleID();

        for (Vehicle o : ola) {
            if (o.getVehLicensePlate().equals(choice.toUpperCase())) {
                str.add(choice.toUpperCase() + " is uninsured");
                dataExport(str);
                //System.out.println(choice.toUpperCase()+ " is uninsured");
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
                    //System.out.println(choice.toUpperCase() + " is insured");
                    unisured = true;
                }
            }
        }
        if (!unisured) {
            str.add(choice.toUpperCase() + " is not in Database");
            dataExport(str);
            //System.out.println(choice + " is not in Database");
        }
    }

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
                System.out.println(list);
                finished = true;
            } else {
                System.out.println("Invalid Input, choose again.");
            }
            }while(!finished);

        }



}
