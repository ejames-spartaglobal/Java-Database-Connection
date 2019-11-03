package com.spartaglobal.java_database_connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class NWOrdersDAO {

    private NorthwindDBManager northwindDBManager = new NorthwindDBManager();


    public Map<String, Integer> orderShippedCount(){
        final String SQL = "SELECT TOP 5 ShipCountry, COUNT(*) AS 'Shipped Amount' FROM Orders GROUP BY ShipCountry ORDER BY [Shipped Amount] DESC";
        Map<String, Integer>shippedCountryMap=new HashMap<>();
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                shippedCountryMap.put(results.getString("ShipCountry"),results.getInt("Shipped Amount"));
                System.out.println(results.getString("ShipCountry")+ " " +results.getInt("Shipped Amount"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return shippedCountryMap;
    }

    public Map<String, Integer> checkProductsPrices(){
        final String SQL = "SELECT ProductName, UnitPrice FROM Products WHERE UnitPrice BETWEEN 15 AND 25 GROUP BY ProductName,UnitPrice ORDER BY UnitPrice ASC";
        Map<String, Integer> productList=new HashMap<>();
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                productList.put(results.getString("ProductName"),results.getInt("UnitPrice"));
                System.out.println(results.getString("ProductName")+ " " +results.getInt("UnitPrice"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return productList;

    }
}
