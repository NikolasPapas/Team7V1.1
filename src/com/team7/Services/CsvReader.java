package com.team7.Services;
import java.io.*;


public class CsvReader {

    public static void loadRecord() {

        String csvFile = "result.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] plateInfo = line.split(cvsSplitBy);
                System.out.println(" First Name: " + plateInfo[0]+  " Last Name: " + plateInfo[1] + " Ai gamisou: " + plateInfo[2]);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        }
