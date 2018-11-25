package com.team7.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvWriter {


        public static void saveRecord(){
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
            first.add(str5);
            first.add(str6);
            second.add(str2);
            second.add(str3);
            second.add(str4);
            second.add(str5);
            second.add(str6);
            exportList.add(first);
            exportList.add(second);

            FileWriter fw  = null;
            try {
                fw = new FileWriter("result.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.println(exportList);
         pw.flush();
         pw.close();

        }

}
