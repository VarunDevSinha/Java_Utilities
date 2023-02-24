package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SerDserUtilityTest extends SerDserUtility {

    static File readFile = new File(".\\src\\test\\java\\com\\resources\\readFile.json");
    static Map<String, Object> readData = new HashMap<String, Object>();

    static File writeFile = new File(".\\src\\test\\java\\com\\resources\\writeFile.json");
    static int[] odcAccess = { 1, 4, 6, 5 };
    static Map<String, Object> writeData = Map.of("EmpId", "TM23784",
            "Name", "Varun Dev Sinha",
            "Grade", "C1",
            "Department", "BFSI IT",
            "Salary", 540000,
            "ODC_Access", odcAccess);

    @Test
    @Order(value = 1)
    public void readJsonDataDeserializerTest() throws IOException {

        readJsonDataDeserializer(readFile, readData);
    }

    @Test
    @Order(value = 2)
    public void writeJsonDataSerializerTest() throws IOException {

        writeJsonDataSerializer(writeFile, writeData);
    }
}
