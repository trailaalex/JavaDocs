package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntityManagerImpl implements EntityManager {

    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        try(Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement()){

            String tableName = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> tableColumn = EntityUtils.getColumns(entityClass);
            List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);
            Condition condition = new Condition();
            condition.setColumnName(fields.get(0).getAnnotation(Id.class).name());
            condition.setValue(id);
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.SELECT).setTableName(tableName).addQueryColumns(tableColumn).addCondition(condition);

            T instance = null;
            ResultSet rs = statement.executeQuery(queryBuilder.createQuery());
            if(rs.next()){
                instance = entityClass.newInstance();
                for(ColumnInfo columnInfo: tableColumn){
                    columnInfo.setValue(rs.getObject(columnInfo.getDbColumnName()));
                    Field field = instance.getClass().getDeclaredField(columnInfo.getColumnName());
                    field.setAccessible(true);
                    if(columnInfo.getValue() instanceof Timestamp)
                        columnInfo.setValue(new Date(((Timestamp) columnInfo.getValue()).getTime()));
                    field.set(instance,EntityUtils.castFromSqlType(columnInfo.getValue(), columnInfo.getColumnType()));
                }
            }
            return instance;

        }catch(Exception ex ){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T findByStringId(Class<T> entityClass, String id) {
        try(Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement()){

            String tableName = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> tableColumn = EntityUtils.getColumns(entityClass);
            List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);
            Condition condition = new Condition();
            condition.setColumnName(fields.get(0).getAnnotation(Id.class).name());
            condition.setValue(id);
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.SELECT).setTableName(tableName).addQueryColumns(tableColumn).addCondition(condition);

            T instance = null;
            ResultSet rs = statement.executeQuery(queryBuilder.createQuery());
            if(rs.next()){
                instance = entityClass.newInstance();
                for(ColumnInfo columnInfo: tableColumn){
                    columnInfo.setValue(rs.getObject(columnInfo.getDbColumnName()));
                    Field field = instance.getClass().getDeclaredField(columnInfo.getColumnName());
                    field.setAccessible(true);
                    if(columnInfo.getValue() instanceof Timestamp)
                        columnInfo.setValue(new Date(((Timestamp) columnInfo.getValue()).getTime()));
                    field.set(instance,EntityUtils.castFromSqlType(columnInfo.getValue(), columnInfo.getColumnType()));
                }
            }
            return instance;

        }catch(Exception ex ){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        try(Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement()){
            String tableName = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> tableColumns = EntityUtils.getColumns(entityClass);

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.SELECT).setTableName(tableName).addQueryColumns(tableColumns);

            String sql = queryBuilder.createQuery();
            ResultSet rs = statement.executeQuery(sql);
            List<T> instances = new ArrayList<>();

            while(rs.next()){
                T instance = entityClass.newInstance();
                for(ColumnInfo columnInfo : tableColumns){
                    columnInfo.setValue(rs.getObject(columnInfo.getDbColumnName()));
                    if(columnInfo.getValue() instanceof Timestamp)
                        columnInfo.setValue(new Date(((Timestamp) columnInfo.getValue()).getTime()));
                    Field field = instance.getClass().getDeclaredField(columnInfo.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, EntityUtils.castFromSqlType(columnInfo.getValue(), columnInfo.getColumnType()));
                }
                instances.add(instance);
            }
            return instances;

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> Object insert(T entity) {
        try(Connection connection = DBManager.getConnection();
            Statement statement = connection.createStatement()){
            String tableName = EntityUtils.getTableName(entity.getClass());
            List<ColumnInfo> tableColumns = EntityUtils.getColumns(entity.getClass());
            Long lastId = null;
            String stringId = null;
            for(ColumnInfo columnInfo : tableColumns){
                if(columnInfo.isId()){
                    Field field = entity.getClass().getDeclaredField(columnInfo.getColumnName());
                    field.setAccessible(true);
                    if(field.getType().equals(String.class)){
                        columnInfo.setValue(EntityUtils.getSqlValue(field.get(entity)));
                        stringId = (String)EntityUtils.getSqlValue(field.get(entity));
                    }else{
                        lastId = getSeqNextVal(tableName, columnInfo.getDbColumnName());
                        columnInfo.setValue(lastId);
                    }
                }else {
                    Field field = entity.getClass().getDeclaredField(columnInfo.getColumnName());
                    field.setAccessible(true);
                    columnInfo.setValue(EntityUtils.getSqlValue(field.get(entity)));
                }
            }

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.INSERT).setTableName(tableName).addQueryColumns(tableColumns);

            String sql = queryBuilder.createQuery();
            statement.executeUpdate(sql);
            if(lastId== null){
                return (T) findByStringId(entity.getClass(), stringId);
            }else{
                return (T) findById(entity.getClass(),lastId);
            }


        }catch(SQLException | ClassNotFoundException | NoSuchFieldException| IllegalAccessException e ){
            e.printStackTrace();
        }
        return null;
    }

    private Long getSeqNextVal(String tableName, String columnIdName){
        ResultSet rs;
        try(Connection con = DBManager.getConnection();
            Statement statement = con.createStatement()){
            rs = statement.executeQuery("select max("+columnIdName+")+1 from "+tableName);
            rs.next();
            return rs.getLong(1);
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public <T> T update(T entity)
    {
        try (Connection con = DBManager.getConnection();
             Statement statement = con.createStatement()){
             String TableName= EntityUtils.getTableName((Class) entity);
             List<ColumnInfo> CoName=EntityUtils.getColumns((Class) entity);
             for(ColumnInfo c:CoName)
             {
                 Field field= null;
                 try {
                     field = entity.getClass().getDeclaredField(c.getColumnName());
                     field.setAccessible(true);
                     c.setValue(field);
                 } catch (NoSuchFieldException e) {
                     e.printStackTrace();
                 }
             }
             QueryBuilder QueryBuilderObj=new QueryBuilder();
              Condition ConditionObject= new Condition();
              ConditionObject.setColumnName(CoName.get(0).getDbColumnName());
              ConditionObject.setValue(CoName.get(0).getValue());
              String SQL= QueryBuilderObj.setQueryType(QueryType.UPDATE).setTableName(TableName).addQueryColumns(CoName).addCondition(ConditionObject).createQuery();
              statement.executeUpdate(SQL);
            Object id = CoName.get(0).getValue();
            if(id instanceof String){
                return (T) findByStringId(entity.getClass(), (String)id);
            }else{
                return (T) findById(entity.getClass(), (Long)id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Statement statement = con.createStatement())
      return null;
    }

    public void delete(Object entity)
    {
        try(Connection con= DBManager.getConnection();
            Statement statement = con.createStatement()){
            String TableName= EntityUtils.getTableName((Class) entity);
            List<ColumnInfo> CoName=EntityUtils.getColumns((Class) entity);
            for(ColumnInfo c:CoName)
            {
                Field field= null;
                try {
                    field = entity.getClass().getDeclaredField(c.getColumnName());
                    field.setAccessible(true);
                    c.setValue(field);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            QueryBuilder QueryBuilderObj=new QueryBuilder();
            Condition ConditionObject= new Condition();
            ConditionObject.setColumnName(CoName.get(0).getDbColumnName());
            ConditionObject.setValue(CoName.get(0).getValue());
            String SQL= QueryBuilderObj.setQueryType(QueryType.DELETE).setTableName(TableName).addQueryColumns(CoName).addCondition(ConditionObject).createQuery();
            statement.executeUpdate(SQL);

     } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

  @Override
   public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        try(Connection con= DBManager.getConnection();
            Statement statement = con.createStatement()){
            String TableName = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> entityColumns = EntityUtils.getColumns(entityClass);
            for (ColumnInfo column : entityColumns) {
                Field field = null;
                try {
                    field = entityClass.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    column.setValue(field);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            QueryBuilder QueryBuilderObj=new QueryBuilder();
            Condition ConditionObject= new Condition();
            ConditionObject.setColumnName(entityColumns.get(0).getDbColumnName());
            ConditionObject.setValue(entityColumns.get(0).getValue());
            String SQL= QueryBuilderObj.setQueryType(QueryType.SELECT).setTableName(TableName)
                    .addQueryColumns(entityColumns).addCondition(ConditionObject).createQuery();

            ResultSet resultSet= statement.executeQuery(SQL);
            List<T> ListInstances= new ArrayList<T>();
            while(resultSet.next())
            {
               T instance= entityClass.newInstance();
                for (ColumnInfo column : entityColumns) {
                    Field field = null;
                    try {
                        field = instance.getClass().getDeclaredField(column.getColumnName());
                        field.setAccessible(true);
                        field.set(instance, resultSet);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
            ListInstances.add(instance);

            }

         return ListInstances;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
     return null;
  }

    /*b)c)	List<T> findByParams(Class<T> entityClass, Map<String, Object> params)

-	create a connection to DB;
-	get table name and columns using the methods from EntityUtils class;
-	iterate through ColumnInfo list
o	getDeclaredField by column name;
o	make the field accessible;
o	set the value of the columnInfo with the value obtained from the field;
-	create a QueryBuilder object  where you set the name of table, query type and conditions;
-	call createQuery() method from QueryBuilder.java;
-	create a Statement object and execute the query;
-	while the resultSet has any values (resultSet.next()) then:
o	 you have to create an instance of type T;
o	iterate through ColumnInfo list and obtain the field of the instance using getColumnName().
Ex: instance.getClass().getDeclaredField(column.getColumnName());
o	make the field accessible;
o	set the value of the field with the value obtained from resultSet object;
o	add the instance in ArrayList;
-	return the ArrayList;


*/
}