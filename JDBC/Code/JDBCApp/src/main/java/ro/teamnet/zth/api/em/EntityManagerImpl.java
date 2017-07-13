package ro.teamnet.zth.api.em;

import javafx.beans.binding.When;
import ro.teamnet.zth.api.annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static java.beans.MetaData.fields;
import static ro.teamnet.zth.api.database.DBManager.getConnection;
import static ro.teamnet.zth.api.em.EntityUtils.getColumns;
import static ro.teamnet.zth.api.em.EntityUtils.getFieldsByAnnotations;
import static ro.teamnet.zth.api.em.EntityUtils.getTableName;

/**
 * Created by Alexandra.Traila on 7/13/2017.
 */
public abstract class EntityManagerImpl implements EntityManager {

    Connection conn=getConnection();

    public EntityManagerImpl() throws SQLException {
    }
    Class entity;
    Class clazz;
    Class annotations;
    String TableName= getTableName(entity);
    List<ColumnInfo> ColumnsName= getColumns(entity);
    List<Field> FieldsName=getFieldsByAnnotations(clazz,annotations);
    Condition ObjectCondition= new Condition();
    ObjectCondition.setValue(id);
    QueryBuilder ObjectQuery=new QueryBuilder();

    ObjectCondition.setColumnName();


    /*-	create a Condition object in which you have to set column name and the value of the id;
-	create a QueryBuilder object  in which you have to set the name of the table, columns, query type and conditions;
-	call createQuery() method from QueryBuilder.java;
-	create a resultSet object using Statement and execute the query obtained above;
-	if the resultSet has any value (resultSet.next()) then:
o	 you have to create an instance of type T;
o	iterate through ColumnInfo list and obtain the field of the instance using getColumnName().
Ex: instance.getClass().getDeclaredField(column.getColumnName());
o	make the field accessible;
o	set the value of the field with the value obtained from resultSet object;

-	return the instance;
*/
}
