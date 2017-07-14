package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexandra.Traila on 7/14/2017.
 */
public class Search {


    public void search(String str)
    {

        String query="SELECT * FROM  DEPARTMENT D, location l  WHERE d.location_id=l.location_id and d.department_name like '%"+str+"%'";

    }

    /*
   1. Search all the employees from a department by the department name.
   The searching method will accept as parameter a String which will be part of the name of the department.
   (The department name should contain this string).

E.g.:
You have the departments: Administration and Construction.
If the method parameter is "STR", then all the employees from the departments Administration and Construction will be found.
     */

    public<T> void insert(List<T> str) throws SQLException, ClassNotFoundException {
        Connection con= DBManager.getConnection();
        con.setAutoCommit(false);
        for(int i=0; i<str.size();i++)
        {
           insert(str);
        }
    }
    /*2. Create an insert method which takes a list of entities as parameter and executes them in a single transaction.
Try a scenario where you inserted 2 or more entities with the same id.
 Create an insert method which takes a list of entities as parameter and executes them in a single transaction. */
}
