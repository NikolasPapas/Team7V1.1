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
 *
 */
public class SqlConnection {
    /**
     * @throws SQLException
     */
    public void connect() {

        /**Arxikopoihsh statement,connection kai resultset
         * */
        Connection con = null;
        Statement st = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        /**Declare querries
         * */
        String query1 = "select * from owner;";
        String query2 = "select * from vehicle;";
        String query3 = "select * from insurance;";

        /**Dhmiourgia listwn gia kathe resultset
         * */
        ArrayList<Owner> ownerList = new ArrayList<>();
        ArrayList<Vehicle> vehiList = new ArrayList<>();
        ArrayList<Insurance> insuList = new ArrayList<>();

        /**Establish connection with db
         * */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/project?autoReconnect=true&useSSL=false", "root", "0123456789");

            /**Dhmiourgia statement*/

            st = con.createStatement();

            /**Owner resultSet
             *
             * 1 Owner Id
             * 2 Owner Name
             *
             *
             * */
            rs1 = st.executeQuery(query1);
            while (rs1.next()) {

                Owner ownr = new Owner();
                ownr.setOwnerName(rs1.getString(2));
                ownr.setOwnerID(rs1.getString(1));
                ownerList.add(ownr);
            }
            OwnerController ownContr = new OwnerController(ownerList);
            for (int i = 0; i < ownerList.size(); i++) {
                System.out.println(ownerList.get(i));
            }

            /**Vehicle resultSet
             * columns
             * 1:ID
             * 2:OwnerID
             * 3:InsurID
             * 4:VehiclePlate
             */

            rs2 = st.executeQuery(query2);
            while (rs2.next()) {
                Vehicle vehi = new Vehicle();
                vehi.setVehLicensePlate(rs2.getString(4));
                vehi.setInsurID(rs2.getString(3));
                vehi.setOwnerID(rs2.getString(2));
                vehi.setVehID(rs2.getString(1));
                vehiList.add(vehi);
            }
            VehicleController vehiContr = new VehicleController(vehiList);
            for (int i = 0; i < vehiList.size(); i++) {
                System.out.println(vehiList.get(i));
            }

            /**Insurance resultSet
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
            for (int i = 0; i < insuList.size(); i++) {
                System.out.println(insuList.get(i));
            }

            /**
             * close connection with db
             *
             * */

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
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