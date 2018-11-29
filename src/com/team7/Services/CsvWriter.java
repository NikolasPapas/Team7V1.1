package com.team7.Services;

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
         * */

    public void saveRecord(ArrayList<String> list) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter((new FileWriter("result.csv"))));
            pw.println(list);
            System.out.println("Data saved to: result.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }

    }
}