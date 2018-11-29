package com.team7.connect;
import com.team7.Controllers.InsuranceController;
import com.team7.Controllers.OwnerController;
import com.team7.Controllers.VehicleController;
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
         * Initiate statement,connection and 1 resultset for each entity(owner,vehicle,insurance)
         *
         * */
        Connection con = null;
        Statement st = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

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
         * */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/project?autoReconnect=true&useSSL=false", "root", "0123456789");

            /**Creation of Statement*/

            st = con.createStatement();

            /** Iterate Owner resultSet and add its contents to ownerList
             * columns:
             * 1 Owner Id
             * 2 Owner Name
             * */
            rs1 = st.executeQuery(query1);
            while (rs1.next()) {

                Owner ownr = new Owner();
                ownr.setOwnerName(rs1.getString(2).toUpperCase());
                ownr.setOwnerID(rs1.getString(1).toUpperCase());
                ownerList.add(ownr);
            }
            OwnerController ownContr = new OwnerController(ownerList);

            /**Iterate vehicle resultset and add its contents to vehiList
             * columns:
             * 1:ID
             * 2:OwnerID
             * 3:InsurID
             * 4:VehiclePlate
             */

            rs2 = st.executeQuery(query2);
            while (rs2.next()) {
                Vehicle vehi = new Vehicle();
                vehi.setVehID(rs2.getString(1));
                vehi.setOwnerID(rs2.getString(2));
                vehi.setInsurID(rs2.getString(3));
                vehi.setVehLicensePlate(rs2.getString(4));
                vehiList.add(vehi);
            }
            VehicleController vehiContr = new VehicleController(vehiList);

            /** Iterate Insurance resultSet and add its contents to insuranceList
             * columns:
             * 1. Insu Id
             * 2. Insu day From
             * 3. Insu day To
             * */

            rs3 = st.executeQuery(query3);
            while (rs3.next()) {
                Insurance insu = new Insurance();
                insu.setInsuranceID(rs3.getString(1));
                insu.setInsuranceFrom(rs3.getDate(2));
                insu.setInsuranceTo(rs3.getDate(3));
                insuList.add(insu);
            }
            InsuranceController insuContr = new InsuranceController(insuList);

            /**
             * close connection with db
             *
             * */
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs1!= null)
                    rs1.close();
                if (rs2 != null)
                    rs2.close();
                if (rs3 != null)
                    rs3.close();
                if (st != null)
                    st.close();
                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}