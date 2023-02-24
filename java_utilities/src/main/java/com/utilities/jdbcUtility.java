package com.utilities;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;

public class jdbcUtility {

    public static void jdbcDBUtility(Map<String, String> jdbcConfigMap) throws Exception {

        Class.forName((String) jdbcConfigMap.get("driverName"));
        // DriverManager.registerDriver(null);

        Connection dbConnection = DriverManager.getConnection(jdbcConfigMap.get("dbURL"),
                jdbcConfigMap.get("dbUserID"),
                jdbcConfigMap.get("dbUserPassword"));

        Statement sqlStatement = (Statement) dbConnection.createStatement();

        ResultSet sqlQueryResult = ((java.sql.Statement) sqlStatement).executeQuery(jdbcConfigMap.get("sqlQuery"));
        sqlQueryResult.getMetaData();
        
    }
}
