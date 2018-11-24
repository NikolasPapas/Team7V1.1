package com.team7.Services;

import java.io.*;

public class CsvWriter {


        public static void saveRecord(){
         String str = "Alelouia";
            FileWriter fw  = null;
            try {
                fw = new FileWriter("result.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         pw.println(str);
         pw.flush();
         pw.close();

        }

}
