package com.weborders.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static { //static block that they will load our properties
        //  try (FileInputStream fileInputStream = new FileInputStream("file.configuration.properties")) {
        //that means we dont have any file.configuration.properteis file so will give an exception
        try (FileInputStream fileInputStream = new FileInputStream("configuration.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to find configuration.properties file!");
            //that is for if will not find the properties file will run that message is
           //find the problem than solve with exception
        }
    }

    public static String getProperty(String key) { //thats for return my property

        return properties.getProperty(key);
    }
/* this is for only to see if works or not
    public static void main(String[] args) {
        System.out.println(getProperty("browser"));
    }

 */

}
