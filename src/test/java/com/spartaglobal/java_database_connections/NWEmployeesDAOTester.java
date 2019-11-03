package com.spartaglobal.java_database_connections;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class NWEmployeesDAOTester {
    private int i=0;
    private NWEmployeesDAO nwEmployeesDAO = new NWEmployeesDAO();
    @Test
    public void getOverSixtiesEmployeesTester(){

        List<String> names = new ArrayList<>();
        names.add("Laura Callahan");
        names.add("Steven Buchanan");
        names.add("Andrew Fuller");
        names.add("Nancy Davolio");
        names.add("Margaret Peacock");
        List<String> ans = nwEmployeesDAO.getOverSixtiesEmployees();
        assertEquals(names, ans);
        //assertEquals(nwEmployeesDAO.getOverSixtiesEmployees().size(), ans.size());
    }

    @Test
    public void getNoOfEmployeesInEachCountry(){
        Map<String, Integer> ans= nwEmployeesDAO.getNoOfEmployeesInEachCountry();
        Map<String, Integer> employeeNum= new HashMap<>();
        employeeNum.put("UK",4);
        employeeNum.put("USA",5);
        assertEquals(employeeNum,ans);
    }

    @Test
    public void checkEmployeesBirthdayTester(){

        List<String> birthday = new ArrayList<>();
        birthday.add("Nancy Davolio 1948-12-08");

        assertEquals(nwEmployeesDAO.checkEmployeeBirthday(),birthday);
    }
}
