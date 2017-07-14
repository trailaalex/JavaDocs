package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * NATO-LOGFS : NCI Agency
 * This source file is the property of the NATO Communications and Information (NCI) Agency, on behalf of NATO.
 * It may not be copied, modified, reused or distributed without the express permission of the NCI Agency.
 * Full terms and conditions are described in LICENSE.TXT, which is part of this software package.
 * Date : 7/12/2017
 * All rights reserved.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection() {
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        assertNotNull(connection);
    }

    @Test
    public void testCheckConnection() {
        try {
            assertTrue(DBManager.checkConnection(DBManager.getConnection()));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
