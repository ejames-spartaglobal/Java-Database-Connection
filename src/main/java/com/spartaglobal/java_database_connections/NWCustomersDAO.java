package com.spartaglobal.java_database_connections;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NWCustomersDAO {

    private NorthwindDBManager northwindDBManager = new NorthwindDBManager();

    public int getLondonCustomers(){
        final String SQL = "SELECT Count(*) AS 'Customer Count' FROM Customers WHERE City = 'London'";
        int customerNum = 0;
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                customerNum = results.getInt("Customer Count");
                System.out.println(customerNum);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customerNum;
    }

    public int getCompanyOwnersCount(){
        final String SQL = "    SELECT COUNT(*) AS 'Owner Count' FROM Customers WHERE ContactTitle = 'Owner'";
        int ownerCount = 0;
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                ownerCount = results.getInt("Owner Count");
                System.out.println(ownerCount);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ownerCount;
    }

    public int checkUKPostalCode(){
        final String SQL = "SELECT COUNT(*) AS 'Correct Postal Addresses' FROM Orders WHERE ShipCountry = 'UK' AND CHARINDEX(' ',ShipPostalCode, 1)=4 OR CHARINDEX(' ',ShipPostalCode, 1)=5\n";
        int postCode = 0;
        try(Statement statement=northwindDBManager.northwindConnection().createStatement()) {
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()){
                postCode=results.getInt("Correct Postal Addresses");
                System.out.println(postCode);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  postCode;
    }

}
