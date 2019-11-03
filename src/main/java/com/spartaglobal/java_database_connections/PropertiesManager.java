package com.spartaglobal.java_database_connections;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private String userName;
    private String password;

    public PropertiesManager() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("resources/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userName=properties.getProperty("username");
        this.password=properties.getProperty("password");
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
