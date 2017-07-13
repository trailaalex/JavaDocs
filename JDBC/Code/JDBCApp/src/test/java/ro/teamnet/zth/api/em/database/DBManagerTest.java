package ro.teamnet.zth.api.em.database;

import ro.teamnet.zth.api.database.DBManager;

import java.sql.Connection;
import java.sql.SQLException;

import static ro.teamnet.zth.api.database.DBManager.getConnection;

/**
 * Created by Alexandra.Traila on 7/13/2017.
 */
public class DBManagerTest {

   Connection conn=getConnection();

   public DBManagerTest() throws SQLException {
   }

    boolean ok=DBManager.checkConnection(conn);


    /*Create in src/test/java/ro/teamnet/zth/api/database  a public class DBManagerTest.java which
    will test getConnection() and checkConnection() methods from DBManager.java.*/

}
