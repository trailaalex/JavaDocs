package ro.teamnet.zth.api.em;

/**
 * Created by Alexandra.Traila on 7/12/2017.
 */
public class ColumnInfo {

String columnName;
Class columnType;
String dbColumnName;
boolean isId;
Object value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public String getDbColumnName() {
        return dbColumnName;
    }

    public void setDbColumnName(String dbColumnName) {
        this.dbColumnName = dbColumnName;
    }

    public boolean isId() {
        return isId;
    }

    public void setId(boolean id) {
        isId = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
