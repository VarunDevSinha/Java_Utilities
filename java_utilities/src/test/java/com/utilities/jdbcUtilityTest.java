package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class jdbcUtilityTest extends jdbcUtility {

    static Map<String, String> jdbcConfigMap;
    static File jdbcConfigFile = new File(".\\src\\test\\java\\com\\resources\\jdbcConfig.properties");

    @BeforeAll
    public void dbSetup() throws IOException {
        FileInputStream jdbcConfigFileIS = new FileInputStream(jdbcConfigFile);
        Properties jdbcConfigProp = new Properties();
        jdbcConfigProp.load(jdbcConfigFileIS);

        jdbcConfigMap = Map.of("driverName", jdbcConfigProp.getProperty("driverName"), "dbURL",
                jdbcConfigProp.getProperty("dbURL"), "dbUserID", jdbcConfigProp.getProperty("dbUserID"),
                "dbUserPassword", jdbcConfigProp.getProperty("dbUserPassword"), "sqlQuery",
                jdbcConfigProp.getProperty("sqlQuery"));
    }

    @Test
    public void jdbcDBUtilityTest() throws Exception {

        jdbcDBUtility(jdbcConfigMap);
    }
}
