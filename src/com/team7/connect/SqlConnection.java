package com.team7.connect;

import java.sql.*;

public class SqlConnection {


    public static void connect(String query, int Flag)throws SQLException {

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
        /**Dhmiourgia query kai apostolh*/
        ResultSet rs = null;
        switch (Flag){
            case 1: connectf1(query,rs,st);
                break;
            case 2:
                //connectf2();
                break;
            case 3:
                //connectf3();
                break;
            case 4:
                //connectf4();
                try {
                    rs.close();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void connectf1(String query, ResultSet rs, Statement st) throws SQLException {
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /**hmiourgia resultset*/
        while (rs.next()) {
            try {
                System.out.println(rs.getString(1));


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}