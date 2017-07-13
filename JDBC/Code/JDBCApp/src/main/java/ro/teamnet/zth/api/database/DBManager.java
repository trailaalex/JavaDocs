package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Alexandra.Traila on 7/13/2017.
 */
public class DBManager {


    private DBManager (){
        throw new UnsupportedOperationException();
    }



   String CONNECTION_STRING= "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";
    private static Class registerDriver() throws ClassNotFoundException {

            return Class.forName(DBProperties.DRIVER_CLASS);

    }

    public static Connection getConnection() throws SQLException {
       // DriverManager.getConnection(CONNECTION_STRING);
        Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver( myDriver );

        // DriverManager.getConnection(CONNECTION_STRING);
        Connection conn = DriverManager.getConnection(DBProperties.DRIVER_CLASS, DBProperties.USER, DBProperties.PASS);
         return conn;

    }

    public static boolean checkConnection(Connection connection) throws SQLException {
        Connection conn=getConnection(); boolean ok=false;
        String SQL="SELECT 1 FROM DUAL";
        try (Statement stmt = conn.createStatement( )){
           return  stmt.execute(SQL);
        }
        catch (SQLException e) {
            System.out.println("Exceptie "+ e.getMessage());
        }
        return false;

    }

}
