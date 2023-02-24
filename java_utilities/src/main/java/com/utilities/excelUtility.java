package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {

    public static void readExcelData(File readFile, Object[][] readData)
            throws IOException, InvalidFormatException {

        FileInputStream readFileIS = new FileInputStream(readFile);

        XSSFWorkbook workbook = new XSSFWorkbook(readFileIS);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int r = 0; r <= sheet.getLastRowNum(); r++) {
            XSSFRow row = sheet.getRow(r);
            for (int c = 0; c < row.getLastCellNum(); c++) {
                XSSFCell cell = row.getCell(c);
                String cellVal = cell.toString();
                readData[r][c] = cellVal;
            }
        }

        workbook.close();
        System.out.println("Successfully created \"readData\" Java object, from \"readFile.xlsx\" file.\n");

        for (int i = 0; i < readData.length; i++) {
            for (int j = 0; j < readData[i].length; j++) {
                System.out.print(readData[i][j] + " | ");
            }
            System.out.print("\n");
        }
    }

    public static void writeExcelData(File writeFile, Object[][] writeData) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("writeData");

        for (int r = 0; r < writeData.length; r++) {
            XSSFRow row = sheet.createRow(r);
            for (int c = 0; c < writeData[r].length; c++) {
                XSSFCell cell = row.createCell(c);
                cell.setCellValue(writeData[r][c].toString());
            }
        }

        FileOutputStream writeFileOS = new FileOutputStream(writeFile);
        workbook.write(writeFileOS);
        writeFileOS.close();
        workbook.close();

        System.out.println("Successfully created \"writeFile.xlsx\" file, from Java object \"writeData\".");
    }
}