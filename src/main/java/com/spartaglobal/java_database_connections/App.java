package com.spartaglobal.java_database_connections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        NWOrdersDAO nwOrdersDAO = new NWOrdersDAO();
        nwOrdersDAO.checkProductsPrices();
//        NWEmployeesDAO nwEmployeesDAO = new NWEmployeesDAO();
//        nwEmployeesDAO.checkEmployeeBirthday();
    }
}
