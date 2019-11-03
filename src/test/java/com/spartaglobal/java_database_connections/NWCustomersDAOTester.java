package com.spartaglobal.java_database_connections;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class NWCustomersDAOTester {

    private NWCustomersDAO nwCustomersDAO = new NWCustomersDAO();

    @Test
    public void getLondonCustomersTester(){
        int ans = nwCustomersDAO.getLondonCustomers();
        int count = 6;
        assertEquals(count,ans);
    }

    @Test
    public void ownerCountTester(){
        int ans = nwCustomersDAO.getCompanyOwnersCount();
        int count = 17;
        assertEquals(count,ans);
    }

    @Test
    public  void checkUKPostalCodeTester(){
        int ans = nwCustomersDAO.checkUKPostalCode();
        int count = 56;
        assertEquals(count,ans);
    }

}
