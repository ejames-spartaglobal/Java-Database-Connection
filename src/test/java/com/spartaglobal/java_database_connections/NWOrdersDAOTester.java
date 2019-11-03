package com.spartaglobal.java_database_connections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class NWOrdersDAOTester {

    private NWOrdersDAO nwOrdersDAO = new NWOrdersDAO();

    @Test
    public void ownerCountTester(){
        Map <String, Integer> ans = nwOrdersDAO.orderShippedCount();
        Map<String, Integer> shippedAmount = new HashMap<>();
        shippedAmount.put("USA", 122);
        shippedAmount.put("Germany", 122);
        shippedAmount.put("Brazil", 83);
        shippedAmount.put("France", 77);
        shippedAmount.put("UK", 56);
        assertEquals(shippedAmount,ans);
    }

    @Test
    public void checkProductPriceTester(){
        Map<String, Integer> ans = nwOrdersDAO.checkProductsPrices();
        Map<String, Integer> prodList=new HashMap<>();
        prodList.put("Outback Lager", 15);
        prodList.put("Röd Kaviar", 15);
        prodList.put("Genen Shouyu", 15);
        prodList.put("Valkoinen suklaa", 16);
        prodList.put("Louisiana Hot Spiced Okra", 17);
        prodList.put("Pavlova", 17);
        prodList.put("Chai", 18);
        prodList.put("Chartreuse verte",18);
        prodList.put("Lakkalikööri",18);
        prodList.put("Steeleye Stout",18);
        prodList.put("Boston Crab Meat",18);
        prodList.put("Chang",19);
        prodList.put("Inlagd Sill",19);
        prodList.put("Gula Malacca",19);
        prodList.put("Ravioli Angelo",19);
        prodList.put("Maxilaku",20);
        prodList.put("Gustaf's Knäckebröd",21);
        prodList.put("Queso Cabrales",21);
        prodList.put("Louisiana Fiery Hot Pepper Sauce",21);
        prodList.put("Chef Anton's Gumbo Mix",21);
        prodList.put("Flotemysost",21);
        prodList.put("Chef Anton's Cajun Seasoning",22);
        prodList.put("Tofu",23);
        prodList.put("Pâté chinois",24);
        prodList.put("Grandma's Boysenberry Spread",25);

        assertEquals(ans,prodList);
    }
}
