package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

public class xmlUtilityTest extends xmlUtility {

    private static File readFile = new File(".\\src\\test\\java\\com\\resources\\readFile.xml");
    private static Map<String, Object> readData = new HashMap<String, Object>();

    private static File writeFile = new File(".\\src\\test\\java\\com\\resources\\writeFile.xml");
    private static Map<String, Object> writeData = Map.of("Employees",
            Map.of("Employee1", Map.of("EmpId", "TM3452",
                    "Name", "Ashwini Swami",
                    "Grade", "CB2",
                    "Department", "BFSI IT",
                    "Salary", "360000",
                    "ODC_Access", List.of(1, 4)),
                    "Employee2", Map.of("EmpId", "TM6654",
                            "Name", "Arunkumar Kapuluru",
                            "Grade", "C1",
                            "Department", "BFSI IT",
                            "Salary", "800000",
                            "ODC_Access", List.of(1, 4, 6)),
                    "Employee3", List.of(Map.of("EmpId", "TL3388",
                            "Name", "Vijayakumar Natarajan",
                            "Grade", "E2",
                            "Department", "BFSI IT",
                            "Salary", "1800000",
                            "ODC_Access", List.of(2, 4, 6))),
                    "Employee4", Map.of("EmpId", "GM00998",
                            "Name", "Rajkumar Palani",
                            "Grade", "F3",
                            "Department", "BFSI IT",
                            "Salary", "2600000",
                            "ODC_Access", List.of(1, 2, 4, 6)),
                    "Employee5", Map.of("EmpId", "TM65874",
                            "Name", "Venkatesh Chinigi",
                            "Grade", "C1",
                            "Department", "BFSI IT",
                            "Salary", "650000",
                            "ODC_Access", List.of(1, 4, 6))));

    @Test
    @Order(value=2)
    @DisplayName(value="")
    public void readXmlDataDeserializerTest() throws StreamReadException, DatabindException, IOException, TransformerException {
        readXmlDataDeserializer(readFile, readData);
    }

    @Test
    @Order(value=1)
    public void writeXmlDataSerializerTest() throws StreamWriteException, DatabindException, IOException {
        writeXmlDataSerializer(writeFile, writeData);
    }
}
