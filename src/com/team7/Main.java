package com.team7;

import com.team7.Controllers.VehicleController;
import com.team7.Services.CsvReader;
import com.team7.Services.CsvWriter;
import com.team7.connect.SqlConnection;
import com.team7.Models.*;
import java.sql.SQLException;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

        /** Main menu*/
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

    /**Function 1*/

    private static void function1()
    {
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Give Vehicle's plate Number: ");
       String choice = keyboard.nextLine();
       System.out.println(choice);
       verifyPlate(choice);
       export();

        List<Vehicle> veh;
        VehicleController vehcontrol = new VehicleController();
        veh = vehcontrol.getVehicleList();
        System.out.println(veh.get(0).getVehLicensePlate());

    }

    /**Function 2*/

    private static void function2()
    {
        CsvWriter writer = new CsvWriter();
        writer.saveRecord();
        //export();
    }
    /**Function 3*/

    private static void function3()
    {

        //export();
    }
    /**Function 4*/

    private static void function4()
    {

        export();
    }
    /**Function Closemenu*/

    private static boolean closemenu()
    {
        return true;
    }
        /** IO connection*/

    private static void export() {
        boolean finished=false;
        do {
            try {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("---- Enter export type:");
                System.out.println("1. File");
                System.out.println("2. Data Base");
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
        } while(!finished);
    }

    /** IO to File*/

    private static void toFile()
    {
        CsvReader reader = new CsvReader();
        reader.loadRecord();
    }
    /** IO to Db*/
    private static void toDb()
    {
        try {
            SqlConnection sql=new SqlConnection();
            sql.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        /**Method for f1 Validation*/
    private static boolean verifyPlate(String plate) {
        if (plate.matches("[A-Z]{3}[-]{1}[0-9]{4}")) {
            System.out.println("This is a Valid license plate!");
            return true;

        } else {
            System.out.println("Invalid input!");
            return false;
        }
    }

}