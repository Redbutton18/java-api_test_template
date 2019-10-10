package com.reqRes.automated.api.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;


public class PropertyLoader {

    private static Properties prop = new Properties();


    private static Properties preloadProperties(PropertySource source) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(source.sourceFile)) {
            Properties properties = new Properties();
            properties.load(resourceStream);
            prop.put(source, properties);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String loadUserDataProperty(String propertyName) {
        Properties properties = (Properties) prop.get(PropertySource.USER);
        if (properties == null)
            properties = preloadProperties(PropertySource.USER);
        String property = properties.getProperty(propertyName);
        if (property == null) {
            return "No property file found";
        } else {
            return property;
        }
    }

    public static String loadDBProperty(String propertyName) {
        Properties properties = (Properties) prop.get(PropertySource.DB);
        if (properties == null)
            properties = preloadProperties(PropertySource.DB);
        String property = properties.getProperty(propertyName);
        if (property == null) {
            return "No property file found";
        } else {
            return property;
        }
    }
}

