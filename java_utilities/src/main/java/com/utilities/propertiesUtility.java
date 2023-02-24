package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class propertiesUtility {

    public static void readPropertiesData(File readFile, Map<String, Object> readData) throws IOException {

        FileInputStream readFileIS = new FileInputStream(readFile);
        Properties readFileProp = new Properties();
        readFileProp.load(readFileIS);

        for (Object key : readFileProp.keySet()) {
            readData.put(key.toString(), readFileProp.get(key));
        }

        System.out.println("Data from \"readFile\" entered to \"readData\" map.");

        for (String keys : readData.keySet()) {
            System.out.println(keys + ":" + readData.get(keys));
        }
    }

    public static void writePropertiesData(File writeFile, Map<String, Object> writeData) throws IOException {

        Properties writeFileProp = new Properties();

        for (Object keys : writeData.keySet()) {
            writeFileProp.setProperty(keys.toString(), writeData.get(keys).toString());
        }

        FileOutputStream outputStrem = new FileOutputStream(writeFile);
        writeFileProp.store(outputStrem, "This is a properties file");

        System.out.println("Data from \"writeData\" map entered to \"writeFile\".");
    }
}
