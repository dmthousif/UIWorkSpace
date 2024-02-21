package com.thetestingacademy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    PropertyReader() {
    }

    public static String readKey(String key) throws Exception {
        FileInputStream fileInputStream = null;
        Properties prop= null;
        try {
            fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/resources/data.properties"));
            prop= new Properties();
            prop.load(fileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(fileInputStream)) {
                fileInputStream.close();
            }
        }

        if (prop.getProperty(key) == null) {
            throw new Exception(prop.getProperty(key) + " not found!!");
        } else {
            return prop.getProperty(key);
        }

    }




}
