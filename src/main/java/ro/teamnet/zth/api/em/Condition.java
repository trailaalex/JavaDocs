package ro.teamnet.zth.api.em;

/**
 * Created by Alexandra.Traila on 7/12/2017.
 */
public class Condition {

    String columnName;
    Object value;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
