package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * NATO-LOGFS : NCI Agency
 * This source file is the property of the NATO Communications and Information (NCI) Agency, on behalf of NATO.
 * It may not be copied, modified, reused or distributed without the express permission of the NCI Agency.
 * Full terms and conditions are described in LICENSE.TXT, which is part of this software package.
 * Date : 7/12/2017
 * All rights reserved.
 */
public class DBManager {

    //private static final String CONNECTION_STRING = "jdbc:postgresql://" + DBProperties.IP + ":" + DBProperties.PORT;
    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT;
    private static boolean isRegistered = false;

    private DBManager() {
        throw new UnsupportedOperationException();
    }

    private static void registerDriver() throws ClassNotFoundException, SQLException {
        if (!isRegistered) {
            //Class.forName(DBProperties.DRIVER_CLASS);
            Driver myDriver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver( myDriver );

            isRegistered = true;
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        registerDriver();
        return DriverManager.getConnection(DBManager.CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
    }

    public static boolean checkConnection(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.execute("SELECT 1 FROM DUAL");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
