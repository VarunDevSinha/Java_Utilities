package com.utilities;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.apache.juneau.xml.XmlSerializer;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;

public class xmlUtility {

    public static void readXmlDataDeserializer(File readFile, Map<String, Object> readData) {

        System.out.println(
                "Deserialization done. Value of \"readFile\" .xml file, deserialized to \"readData\" Java map.\n");

        // Printing Java map create from XML file.
        System.out.println("\nXML representation of Java map:\n" + readData);
    }

    public static void writeXmlDataSerializer(File writeFile, Map<String, Object> writeData)
            throws StreamWriteException, DatabindException, IOException {

        // Creating XML string from Java Map
        XmlSerializer xmlSerialize = XmlSerializer.DEFAULT_NS_SQ_READABLE;
        String xmlData = xmlSerialize.serialize(writeData).toString();
        System.out.println("Serialization done. \"writeData\" Java map serialized to XML string with name \"xmlData\"."
                + "\nxmlData in XML format:\n" + xmlData);

        // Writing XML string to XML file
        FileWriter writeFileWriter = new FileWriter(writeFile);
        writeFileWriter.write(xmlData);
        writeFileWriter.close();
        System.out.println(
                "Created XML file from serialized Java map to XML string." + "File name: " + writeFile.getName());
    }
}
