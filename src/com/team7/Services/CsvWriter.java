package com.team7.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvWriter {


    public void saveRecord() {
        List<List> exportList = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        String str2 = "Alelouia";
        String str3 = "Alelouia1";
        String str4 = "Alelouia2";
        String str5 = "Alelouia3";
        String str6 = "Alelouia4";
        first.add(str2);
        first.add(str3);
        first.add(str4);
        first.add(str3);
        first.add(str3);
        second.add(str2);
        second.add(str6);
        second.add(str6);
        second.add(str6);
        second.add(str6);
        exportList.add(first);
        exportList.add(second);


        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter((new FileWriter("result.csv"))));
            pw.println(exportList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pw.flush();
        pw.close();
    }
}