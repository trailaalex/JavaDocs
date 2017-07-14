package ro.teamnet.zth.api.database;

import java.sql.*;
import java.util.Properties;

/**
 * NATO-LOGFS : NCI Agency
 * This source file is the property of the NATO Communications and Information (NCI) Agency, on behalf of NATO.
 * It may not be copied, modified, reused or distributed without the express permission of the NCI Agency.
 * Full terms and conditions are described in LICENSE.TXT, which is part of this software package.
 * Date : 7/13/2017
 * All rights reserved.
 */
public class Example {

    public void exampleConnection() {

        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        try {
            DriverManager.registerDriver(myDriver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String URL = "jdbc:oracle:thin:@localhost:1521";
        Properties info = new Properties();
        info.put("user", "sys as sysdba");
        info.put("password", "admin");

        Connection conn = null;


        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", info);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Statement stmt = conn.createStatement()) {
            conn.setAutoCommit(false);

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM DEPARTMENTS");
            //int randuriAfectate = stmt.executeUpdate("");
            while (resultSet.next()) {
                System.out.println("NUME DEPARTAMENT : " + resultSet.getString("department_name"));
            }

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Example example = new Example();
        example.exampleConnection();
    }
}
