package com.team7.connect;
import com.team7.Controllers.InsuranceController;
import com.team7.Models.Insurance;
import com.team7.Models.Owner;
import com.team7.Models.Vehicle;
import com.team7.DataSave.SingletonDataSave;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SqlConnection {
    private static SingletonDataSave singletonClass;
    /**
     *
     * @throws SQLException
     */
    public static void connect()throws SQLException {
        singletonClass = SingletonDataSave.getInstance();
        /**Declare querries*/

        String query1 = "select * from owner;";
        String query2 = "select * from vehicle;";
        String query3 = "select * from insurance;";

        /**Establish connection with db*/

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con= null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/project?autoReconnect=true&useSSL=false","root","0123456789");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /**Dhmiourgia statement*/
        Statement st = null;
        try {
            st = con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        /**Dhmiourgia resultset*/
        List<Owner> ownerList = new ArrayList<>();
        List<Vehicle> vehiList = new ArrayList<>();
        List<Insurance> insuList = new ArrayList<>();
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        /**Owner resultSet
         *
         * 1 Owner Id
         * 2 Owner Name
         *
         *
         * */

        try {
            rs1 = st.executeQuery(query1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs1.next()) {
            try {
                Owner ownr = new Owner();
                ownr.setOwnerName(rs1.getString(2));
                ownr.setOwnerID(rs1.getString(1));
                ownerList.add(ownr);

                //System.out.println(rs1.getString(1)+","+rs1.getString(2));
            } catch (SQLException e) {
                e.printStackTrace(); }
        }
        // TODO: SingletonDataSave.setSingletonOwner(ownerList);
        for (int i=0; i<ownerList.size();i++){
            System.out.println( ownerList.get(i));
        }
        rs1.close();


        /**Vehicle resultSet

         *
         * columns
         * 1:ID
         * 2:OwnerID
         * 3:InsurID
         * 4:VehiclePlate
         *
         */

        try {
            rs2 = st.executeQuery(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs2.next()) {
            try {
                Vehicle vehi = new Vehicle();
                vehi.setVehLicensePlate(rs2.getString(4));
                vehi.setVehID(rs2.getString(1));

                vehiList.add(vehi);
                //System.out.println(rs2.getString(1)+","+rs2.getString(2)+","+rs2.getString(3)+","+rs2.getString(4));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //TODO: SingletonDataSave.setOneVehicle(Vehicle)
        //SingletonDataSave.setSingletonVehicle(vehiList);
        for (int i=0; i<ownerList.size();i++){
            System.out.println( vehiList.get(i));
        }
        rs2.close();

        /**Insurance resultSet
         *
         * 1. Insu Id
         * 2. Insu day From
         * 3. Insu day To
         *
         * */

        try {
            rs3 = st.executeQuery(query3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs3.next()) {
            try {
                Insurance insu = new Insurance();
                insu.setInsuranceID(rs3.getString(1));
                insu.setInsuranceFrom(rs3.getDate(2));
                insu.setInsuranceTo(rs3.getDate(3));
                insuList.add(insu);
                System.out.println(rs3.getString(1)+","+rs3.getDate(2)+","+rs3.getDate(3));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //TODO: SingletonDataSave.setOneInsurance(Insurance)
        //SingletonDataSave.setSingletonInsurance(insuList);
        for (int i=0; i<ownerList.size();i++){
            System.out.println( insuList.get(i));
        }
        rs3.close();

        /**
         * close connection with db
         *
         * */

        st.close();
        con.close();
    }

}