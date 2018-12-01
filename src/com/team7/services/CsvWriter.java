package com.team7.services;

import com.team7.Main;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Vagelis Giannakosian
 *
 * */

public class CsvWriter {
        /**
         * Public method saveRecord()
         * when saveRecord() is called with an ArrayList<string> as the argument,
         * it establishes connection with "result.csv", located in the local directory,
         * and after it prints the contents of the Arraylist, it closes the connection.
         * @implemented with try-with-resources
         * */

    public void saveRecord(ArrayList<String> list) {

        try( PrintWriter pw =  new PrintWriter(new BufferedWriter(new FileWriter("result.csv")));    )
        {
            for (String str:list){
            pw.println(str);
            }
            System.out.println("Data saved to: result.csv");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Main menu = new Main();
            menu.Menu();
        }

    }
}