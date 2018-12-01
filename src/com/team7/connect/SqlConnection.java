package com.team7.connect;
import com.team7.Controllers.InsuranceController;
import com.team7.Controllers.OwnerController;
import com.team7.Controllers.VehicleController;
import com.team7.Main;
import com.team7.Models.Insurance;
import com.team7.Models.Owner;
import com.team7.Models.Vehicle;
import java.sql.*;
import java.util.ArrayList;

/**
 ** @author Vagelis Giannakosian
 *
 */
public class SqlConnection {

    /** Public method connect()
     * Establishes connection with DataBase "project" on localhost
     * and returns 3 resultsets, 1 for each table(owner,vehicle,insurance).
     * Each tables is then transfered to singletonclass through
     * its respective controller
     * */

    public void connect() {

        /**
         * Declare querries
         * */
        String query1 = "select * from owner;";
        String query2 = "select * from vehicle;";
        String query3 = "select * from insurance;";

        /**
         * Initiate 1 Arraylist for each resultset
         * */
        ArrayList<Owner> ownerList = new ArrayList<>();
        ArrayList<Vehicle> vehiList = new ArrayList<>();
        ArrayList<Insurance> insuList = new ArrayList<>();

        /**
         * Establish connection with db
         * using try with resources
         * */
        try (Connection con= DriverManager.getConnection("jdbc:mysql://localhost/project?autoReconnect=true&useSSL=false", "root", "0123456789");
             Statement st1=con.createStatement();
             Statement st2=con.createStatement();
             Statement st3=con.createStatement();
             ResultSet rs1=st1.executeQuery(query1);
             ResultSet rs2=st2.executeQuery(query2);
             ResultSet rs3=st3.executeQuery(query3);
        )
        {

            /** Iterate Owner resultSet, add its contents to ownerList
             * and send the ownerList to Singleton through the OwnerController
             * columns:
             * 1 Owner Id
             * 2 Owner Name
             * */
            while (rs1.next()) {

                Owner ownr = new Owner();
                ownr.setOwnerName(rs1.getString(2).toUpperCase());
                ownr.setOwnerID(rs1.getString(1).toUpperCase());
                ownerList.add(ownr);
            }
            OwnerController ownContr = new OwnerController(ownerList);

            /**Iterate vehicle resultset, add its contents to vehiList
             * and send the vehiList to Singleton through the VehicleController
             * columns:
             * 1:ID
             * 2:OwnerID
             * 3:InsurID
             * 4:VehiclePlate
             */

            while (rs2.next()) {
                Vehicle vehi = new Vehicle();
                vehi.setVehID(rs2.getString(1).toUpperCase());
                vehi.setOwnerID(rs2.getString(2).toUpperCase());
                vehi.setInsurID(rs2.getString(3).toUpperCase());
                vehi.setVehLicensePlate(rs2.getString(4).toUpperCase());
                vehiList.add(vehi);
            }
            VehicleController vehiContr = new VehicleController(vehiList);

            /** Iterate Insurance resultSet and add its contents to insuranceList
             * and send the insuranceList to Singleton through the InsuranceController
             * columns:
             * 1. Insu Id
             * 2. Insu day From
             * 3. Insu day To
             * */

            while (rs3.next()) {
                Insurance insu = new Insurance();
                insu.setInsuranceID(rs3.getString(1).toUpperCase());
                insu.setInsuranceFrom(rs3.getDate(2));
                insu.setInsuranceTo(rs3.getDate(3));
                insuList.add(insu);
            }
            InsuranceController insuContr = new InsuranceController(insuList);

            /**
             * if there is an error with the Db
             * send error message and create new Menu
             * else close the Db
             * */
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Main menu = new Main();
            menu.Menu();

        }

    }
}