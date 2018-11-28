package com.team7.Services;

import java.io.*;
import java.util.ArrayList;

public class CsvWriter {


    public void saveRecord(ArrayList<String> list) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter((new FileWriter("result.csv"))));
            pw.println(list);
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