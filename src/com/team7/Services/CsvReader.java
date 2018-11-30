package com.team7.Services;
import com.team7.Controllers.*;
import com.team7.Main;
import com.team7.Models.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.util.ArrayList;


public class CsvReader {

    public void loadRecord() {
        /**
         *
         * use comma as separator for the split of the csv file
         *
         * */
        String csvFile = "data.csv";
        String line = "";
        String cvsSplitBy = ",";

        /**@author Vagelis Giannakosian
         *Initializa 1 Arraylist for each Entity - owner,vehicle,insurance
         */

        ArrayList<Owner> ownerList = new ArrayList<>();
        ArrayList<Vehicle> vehiList = new ArrayList<>();
        ArrayList<Insurance> insuList = new ArrayList<>();

        /**@author Vagelis Giannakosian
         * Initiate  connection with File
         * try with resources
         * */
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){


            while ((line = br.readLine()) != null) {
                String[] plateInfo = line.split(cvsSplitBy);

                /**@author Vagelis Giannakosian
                 *For each line of the csv File, instantiate a new owner,
                 * set the Owner Id with the content of column 0
                 * and the Owner Name with the content of column 1
                 * Finally add the owner to the ownerList*/

                Owner ownr = new Owner();
                ownr.setOwnerName(plateInfo[1].toUpperCase());
                ownr.setOwnerID(plateInfo[0].toUpperCase());
                ownerList.add(ownr);

                /**@author Vagelis Giannakosian
                 *For each line of the csv File, instantiate a new vehicle,
                 * set the Vehicle Id with the content of column 2
                 * the Vehicle's Plate with the content of column 3
                 * the vehicle's insuranceId with the content of column 4
                 * and the vehicle's owner name with the content of column 0
                 * Finally add the vehicle to the vehicleList*/

                Vehicle vehi = new Vehicle();
                vehi.setVehID(plateInfo[2].toUpperCase());
                vehi.setVehLicensePlate(plateInfo[3].toUpperCase());
                vehi.setInsurID(plateInfo[4].toUpperCase());
                vehi.setOwnerID(plateInfo[0].toUpperCase());

                vehiList.add(vehi);

                /**@author Vagelis Giannakosian
                 *For each line of the csv File, instantiate a new insurance,
                 * set the Insurance Id with the content of column 4
                 */
                Insurance insu = new Insurance();
                insu.setInsuranceID(plateInfo[4].toUpperCase());

                /**@author Vagelis Giannakosian
                 *Change the String format of column 5,6 to Date
                 */
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = new Date();
                Date d2 = new Date();
                try {
                     d1 = df.parse(plateInfo[5].toUpperCase());
                     d2 = df.parse(plateInfo[6].toUpperCase());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                /**  @author Vagelis Giannakosian
                 * Set the Insurance's Day_From to column 5
                 * set the Insurance's Expiration_Day to column 6
                 * */
                insu.setInsuranceFrom(d1);
                insu.setInsuranceTo(d2);
                /**Finally add the new insurance to the insuranceList*/
                insuList.add(insu);

            }
            /**@author Vagelis Giannakosian
             *Instantiate each Controller with its respective Arraylist
             * */
            OwnerController ownContr = new OwnerController(ownerList);
            VehicleController vehiContr = new VehicleController(vehiList);
            InsuranceController insuContr = new InsuranceController(insuList);

                /**@author Vagelis Giannakosian
                 * if the connection throws exception, return exceptions's message
                 * and create new Main Menu
                 **/
                } catch (IOException e) {
                System.out.println(e.getMessage());
                Main menu = new Main();
                menu.Menu();
                }

    }

}
