package com.team7.connect;

import java.sql.*;

public class SqlConnection {


    public static void connect()throws SQLException {
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

        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;

        /**Owner resultSet*/
        try {
            rs1 = st.executeQuery(query1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs1.next()) {
            try {
                System.out.println(rs1.getString(1)+","+rs1.getString(2));
            } catch (SQLException e) {
                e.printStackTrace(); }
        }
        rs1.close();



        /**Vehicle resultSet*/

        try {
            rs2 = st.executeQuery(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs2.next()) {
            try {
                System.out.println(rs2.getString(1)+","+rs2.getString(2)+","+rs2.getString(3)+","+rs2.getString(4));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rs2.close();

        /**Insurance resultSet*/

        try {
            rs3 = st.executeQuery(query3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs3.next()) {
            try {
                System.out.println(rs3.getString(1)+","+rs3.getDate(2)+","+rs3.getDate(3));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        rs3.close();

        /**close connection with db*/

        st.close();
        con.close();
    }

}


