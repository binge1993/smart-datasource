package com.binge.smart.datasource.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author binge
 * @datetime 2017年9月27日
 * @version
 * @encoding UTF8
 * @Description properties文件工具类
 */

public class PropertiesManager {
    private static Properties pro = new Properties();

    private PropertiesManager() {

    }

    static {
        try {
            pro.load(PropertiesManager.class.getClassLoader().getResourceAsStream("DB.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return pro.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return pro.getProperty(key, defaultValue);
    }

    public static Enumeration<?> propertiesNames() {
        return pro.propertyNames();
    }
}