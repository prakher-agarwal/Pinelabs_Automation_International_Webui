package com.pinelabs.RnD.CommonUtils;

import com.pinelabs.RnD.AndroidUI.Constants.FilePaths;

import java.sql.*;
import java.util.Map;

public class SQLDatabaseUtility {
    public static Connection con;
    public static Statement stmt;
    public static ResultSet row;
    static Map<Object, Object> value;
    static String query;

    public static Connection setUPConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(CommonUtility.readPropertyfile(FilePaths.dbPropertiesPath).getProperty("sqlDbConnectionURL"));

            System.out.println("SQL Connection established");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

    private static String fetchQuery(String query, Map<Object, Object> values) {

        for (Object key : values.keySet()) {
            query = query.replaceAll(key.toString(), values.get(key).toString());
        }
        System.out.println(query);
        return query;
    }


    public static void executeSelectquery(String sqlQuery, Map<Object, Object> values) {
        query = fetchQuery(sqlQuery, values);

        try {
            stmt = con.createStatement();
            row = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdateQuery(String sqlQuery, Map<Object, Object> values) {
        query = fetchQuery(sqlQuery, values);

        try {
            stmt = con.createStatement();
            row = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public String fetchQuery(String dbQuery, Map<Object, Object> params) {
//        String query = null;
//        try {
//            List<String> listMatches = DatabaseUtil.getInstance().getMatches(dbQuery);
//            query = dbQuery;
//            for (int j = 0; j < listMatches.size(); j++) {
//                String key = listMatches.get(j);
//                if (params.containsKey(DBEnums.valueOf(key))) {
//                    query = query.replaceAll("\\b" + key + "\\b", params.get(DBEnums.valueOf(key)).toString())
//                            .replace("$", "");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return query;
//    }
//    // Initialize SQL DB Table
//    public void initializeSqlDb(String tableName) {
//        tableName = tableName.toUpperCase();
//        valuesSqlDB = new HashMap<>();
//        try {
//            String sqlURL = sqlDbProperties.getProperty("SqlURL");
//            String queryToExecute = sqlDbProperties.getProperty(tableName);
//            Connection con = DriverManager.getConnection(sqlURL);
//            System.out.println("SQL Connection established");
//            Statement stmt = con.createStatement();
//            ResultSet row = stmt.executeQuery(queryToExecute);
//            ResultSetMetaData tbl = row.getMetaData();
//            int columnsNumber = tbl.getColumnCount();
//            int countNullValuesInSql = 0;
//            while (row.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    String columnName = tbl.getColumnName(i);
//                    String columnValue = row.getString(i);
//                    if (notNull(columnName) && notNull(columnValue)) {
//                        columnName = dataModifier(columnName);
//                        columnValue = dataModifier(columnValue);
//                    } else {
//                        countNullValuesInSql++;
//                    }
//                    if (columnName.equalsIgnoreCase("INVOICE_NUMBER") || columnName.equalsIgnoreCase("ACQ_BATCH_NUMBER_FOR_CHARGESLIP")) {
//                        while (columnValue.length() < 6) {
//                            columnValue = "0" + columnValue;
//                        }
//                    }
//                    valuesSqlDB.put(columnName, columnValue);
//                }
//            }
//// if(countNullValuesInSql!=0) {
//// System.out.println("Some Column names or Values in " + tableName + " are Null - Check in Sql");
//// System.out.println("Null Values Count: "+ countNullValuesInSql);
//// }
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println("ERROR occured in executing SQL Query");
//        }
//    }
}



