package com.spartaglobal.java_database_connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NWEmployeesDAO {

    private NorthwindDBManager northwindDBManager = new NorthwindDBManager();
    List<String>employees = new ArrayList<>();

    public void iterateThroughEmployees(){
        final String SQL = "SELECT TOP 5 firstName, lastName FROM Employees";

        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);

            while (results.next()){
                System.out.println(results.getString("FirstName") + " " + results.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getTotalEmployeeNum(){
        final String SQL = "SELECT COUNT(*) AS 'Total' FROM Employees";
        int employeeNum=0;
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);

            while (results.next()){
            employeeNum=results.getInt("Total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(employeeNum);
        return employeeNum;
    }

    public List<String> getOverSixtiesEmployees(){
        final String SQL = "SELECT  TOP 10 FirstName, LastName FROM Employees WHERE YEAR(GETDATE())-YEAR(BirthDate)>60 ORDER BY BirthDate DESC";
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                employees.add(results.getString("firstName") + " " + results.getString("lastName"));
               // System.out.println(results.getString("FirstName") + " " + results.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public Map<String, Integer> getNoOfEmployeesInEachCountry(){
        final String SQL= "SELECT Country, Count(*) AS \"Number of Employees\" FROM Employees GROUP BY Country";
        Map<String, Integer>employeesInEachCountry=new HashMap<>();
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                employeesInEachCountry.put(results.getString("Country"),results.getInt("Number of Employees"));
                System.out.println(results.getString("Country")+ " " +results.getInt("Number of Employees"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return employeesInEachCountry;
}

    public List<String> checkEmployeeBirthday(){
        final String SQL = "SELECT FirstName + ' ' + LastName AS 'Name', BirthDate FROM Employees WHERE MONTH(BirthDate) BETWEEN MONTH(GETDATE()) AND MONTH(GETDATE())+4";
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                employees.add(results.getString("Name") + " " + results.getDate("BirthDate"));
                System.out.println(results.getString("Name") + " " + results.getDate("BirthDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

}
