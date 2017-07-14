package ro.teamnet.zth.api.database;

/**
 * NATO-LOGFS : NCI Agency
 * This source file is the property of the NATO Communications and Information (NCI) Agency, on behalf of NATO.
 * It may not be copied, modified, reused or distributed without the express permission of the NCI Agency.
 * Full terms and conditions are described in LICENSE.TXT, which is part of this software package.
 * Date : 7/12/2017
 * All rights reserved.
 */
public interface DBProperties {
    /*String IP = "localhost";
    String PORT = "5432";
    String USER = "postgres";
    String PASS = "postgres";
    String DRIVER_CLASS = "org.postgresql.Driver";*/

    String IP = "localhost";
    String PORT = "1521";
    //TODO de inlocuit cu utilizatorul vostru
    String USER = "sys as sysdba";
    //TODO de inlocuit cu parola voastra
    String PASS = "admin";
    String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
}
