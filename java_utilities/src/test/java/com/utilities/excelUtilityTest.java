package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class excelUtilityTest extends excelUtility {

    File readFile = new File(".\\src\\test\\java\\com\\resources\\readFile.xlsx");
    File writeFile = new File(".\\src\\test\\java\\com\\resources\\writeFile.xlsx");

    Object[][] readData = new Object[6][5];
    Object[][] writeData = { { "EmpId", "Name", "Grade", "Department", "Salary" },
            { "TM3452", "Ashwini Swami", "CB2", "BFSI IT", 36000 },
            { "TM6654", "Arunkumar Kapuluru", "C1", "BFSI IT", 800000 },
            { "TL3388", "Vijayakumar Natarajan", "E2", "BFSI IT", 1800000 },
            { "GM00998", "Rajkumar Palani", "F3", "BFSI IT", 2600000 },
            { "TM65874", "Venkatesh Chinigi", "C1", "BFSI IT", 650000 } };

    @Test()
    @Order(value = 1)
    public void readExcelDataTest() throws IOException, InvalidFormatException {
        readExcelData(readFile, readData);
    }

    @Test
    @Order(value = 2)
    public void writeExcelDataTest() throws IOException {

        writeExcelData(writeFile, writeData);
    }
}
