package ro.teamnet.zth.api.em;

import javafx.scene.effect.Reflection;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexandra.Traila on 7/12/2017.
 */
public class EntityUtils {

    private EntityUtils(){
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity)
    {
        Table t= (Table) entity.getAnnotation(Table.class);
        return t.name();
    }

    public static List getColumns(Class entity)
    {

        List<Field> ColumnInfo = new ArrayList<Field>();
        Field[] fs = entity.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fs)
        {
            Table t= (Table) field.getAnnotation(Table.class);
            field.setAccessible(true);
            if(t.name()=="@Column" || t.name()=="@Id")
                ColumnInfo.addAll(Arrays.asList(entity.getClass().getDeclaredFields()));
            //System.out.println( field.get( a ) );
        }
        return ColumnInfo;
    }

    public static Object castFromSqlType(Object value, Class wantedType)
    {
        if(value)
    }
  /* -	create a public static method castFromSqlType(Object value, Class wantedType),
   where value is the value from DB and wantedType is the type of value which you want to use.
    The return type is Object. This method is used to cast the type of “id” column from DB to id field from the entities.
     Steps:
•	if value is BigDecimal and wantedType is Integer then you will return an Interger;
•	if value is BigDecimal and wantedType is Long then you will return an Long;
•	if value is BigDecimal and wantedType is Float then you will return an Float;
•	if value is BigDecimal and wantedType is Double then you will return an Double;
•	if value is different from BigDecimal then the method will return that value;

*/
}
