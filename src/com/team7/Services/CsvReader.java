package com.team7.Services;
import com.team7.Controllers.InsuranceController;
import com.team7.Controllers.OwnerController;
import com.team7.Controllers.VehicleController;
import com.team7.Models.Insurance;
import com.team7.Models.Owner;
import com.team7.Models.Vehicle;
import java.text.*;
import java.util.Date;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;


public class CsvReader {

    public void loadRecord() {

        String csvFile = "data.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
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
                ownr.setOwnerName(plateInfo[0]);
                ownr.setOwnerID(plateInfo[1]);
                ownerList.add(ownr);

                /**Create Vehicle List*/
                Vehicle vehi = new Vehicle();
                vehi.setVehLicensePlate(plateInfo[3]);
                vehi.setInsurID(plateInfo[4]);
                vehi.setOwnerID(plateInfo[0]);
                vehi.setVehID(plateInfo[2]);
                vehiList.add(vehi);

                /**Create Insurance List*/
                Insurance insu = new Insurance();
                insu.setInsuranceID(plateInfo[4]);
                /**change the date's format*/
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = new Date();
                Date d2 = new Date();
                try {
                     d1 = df.parse(plateInfo[5]);
                     d2 = df.parse(plateInfo[6]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                insu.setInsuranceFrom(d1);
                insu.setInsuranceTo(d2);
                insuList.add(insu);

            }
            /**Send Lists to the controllers*/
            OwnerController ownContr = new OwnerController(ownerList);
            InsuranceController insuContr = new InsuranceController(insuList);
            VehicleController vehiContr = new VehicleController(vehiList);

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
