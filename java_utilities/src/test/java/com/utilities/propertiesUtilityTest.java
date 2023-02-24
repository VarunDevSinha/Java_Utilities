package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class propertiesUtilityTest extends propertiesUtility {

    public static File readFile = new File(".\\src\\test\\java\\com\\resources\\readData.properties");
    public static Map<String, Object> readData = new HashMap<String, Object>();

    public static File writeFile = new File(".\\src\\test\\java\\com\\resources\\writeData.properties");
    public static Map<String, Object> writeData = Map.of("EmpId", "TM23784",
            "Name", "Varun Dev Sinha",
            "Grade", "C1",
            "Department", "BFSI IT",
            "Salary", 540000);

    @Test
    @Order(value = 1)
    public void readPropertiesDataTest() throws IOException {

        readPropertiesData(readFile, readData);
    }

    @Test
    @Order(value = 2)
    public void writePropertiesDataTest() throws IOException {

        writePropertiesData(writeFile, writeData);
    }
}
