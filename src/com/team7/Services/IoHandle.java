package com.team7.Services;

import com.team7.connect.SqlConnection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IoHandle {

    /**@author Vagelis Giannakosian
     *  Method dataImport()
     *  It asks the user to choose between file and database as the source of tha data
     *  if the user chooses '1', method toFile() is called
     *  if the user chooses '2', method toDb() is called
     */
    public void  dataImport() {
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

    private void toFile() {
        CsvReader reader = new CsvReader();
        reader.loadRecord();
    }

    /**@author Vagelis Giannakosian
     * Data import from Db
     * instantiates a new object of Sqlconnection
     * and calls the connect() method
     */
    private void toDb() {
        SqlConnection sql = new SqlConnection();
        sql.connect();
    }

    /**@author Vagelis Giannakosian
     * method dataExport()
     * Takes an argument of Arraylist<string> list
     * lets the user choose where to print the requested data
     * if he chooses '1', the saveRecord(list) is called
     * if he chooses '2', the list of data is printed to the console
     * */

    public void dataExport(ArrayList<String> list) {
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
}
