package com.team7;

import java.sql.SQLException;
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
    }

    /**Function 2*/

    private static void function2()
    {
        com.team7.Services.CsvWriter.saveRecord();
        //export();
    }
    /**Function 3*/

    private static void function3()
    {
        com.team7.Services.CsvReader.loadRecord();
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

    }
    /** IO to Db*/
    private static void toDb()
    {
        try {
            com.team7.connect.SqlConnection.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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