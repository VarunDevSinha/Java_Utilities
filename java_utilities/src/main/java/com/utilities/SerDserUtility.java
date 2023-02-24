package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.apache.juneau.json.Json5Serializer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerDserUtility {

    public static void readJsonDataDeserializer(File readFile, Map<String, Object> readData) throws IOException {

        // Reading JSON file and creating Java MAP.
        ObjectMapper objMap = new ObjectMapper();
        readData = objMap.readValue(readFile, new TypeReference<Map<String, Object>>() {
        });
        System.out.println("Deserialization done. Value of \"readFile\" .JSON file, deserialized to \"readData\" Java map.");

        // Printing MAP value
        System.out.println("Deserialized data from \"readData\" Java map.");
        for (Object key : readData.keySet()) {
            String valueArrayStr = readData.get(key).toString();
            Object[] valueArray = valueArrayStr.split("},");
            for (Object value : valueArray) {
                System.out.println(value);
            }
        }
        readData.forEach((k, v) -> System.out.println("\nMap view of \"readData\" Java map.\n" + k + ":" + v));

    }

    public static void writeJsonDataSerializer(File writeFile, Map<String, Object> writeData) throws IOException {
        
        // Writing JSON file from Java MAP.
        ObjectMapper objMap = new ObjectMapper();
        objMap.writeValue(writeFile, writeData);
        System.out.println("Serialization done. Data from \"writeData\" Java map, writen to \"writeFile\" .Json file.");

        // Serialization by creating a JSON string.
        System.out.println("Serialization done. Value of \"writeData\" Java map, serialized to JSON string.");
        Json5Serializer serializer = Json5Serializer.DEFAULT_READABLE;
        String jsonString = serializer.serialize(writeData).toString();
        System.out.println(jsonString);

    }

}
