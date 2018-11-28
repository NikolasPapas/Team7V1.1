package com.team7.Services;
import com.team7.Controllers.*;
import com.team7.Models.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.util.ArrayList;


public class CsvReader {

    public void loadRecord() {

        String csvFile = "data.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        /**Αρχικοποίηση Λιστών*/
        ArrayList<Owner> ownerList = new ArrayList<>();
        ArrayList<Vehicle> vehiList = new ArrayList<>();
        ArrayList<Insurance> insuList = new ArrayList<>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] plateInfo = line.split(cvsSplitBy);

                /**Create Owner List*/
                Owner ownr = new Owner();
                ownr.setOwnerName(plateInfo[1].toUpperCase());
                ownr.setOwnerID(plateInfo[0].toUpperCase());
                ownerList.add(ownr);

                /**Create Vehicle List*/
                Vehicle vehi = new Vehicle();
                vehi.setVehLicensePlate(plateInfo[3].toUpperCase());
                vehi.setInsurID(plateInfo[4].toUpperCase());
                vehi.setOwnerID(plateInfo[0].toUpperCase());
                vehi.setVehID(plateInfo[2].toUpperCase());
                vehiList.add(vehi);

                /**Create Insurance List*/
                Insurance insu = new Insurance();
                insu.setInsuranceID(plateInfo[4].toUpperCase());
                /**change the date's format*/
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = new Date();
                Date d2 = new Date();
                try {
                     d1 = df.parse(plateInfo[5].toUpperCase());
                     d2 = df.parse(plateInfo[6].toUpperCase());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                insu.setInsuranceFrom(d1);
                insu.setInsuranceTo(d2);
                insuList.add(insu);

            }
            /**Creating Lists in the controllers*/
            OwnerController ownContr = new OwnerController(ownerList);
            VehicleController vehiContr = new VehicleController(vehiList);
            InsuranceController insuContr = new InsuranceController(insuList);

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
