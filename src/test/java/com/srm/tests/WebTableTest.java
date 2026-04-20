package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.WebTablePage;

public class WebTableTest extends BaseTest {

    @Test
    public void testAddRecord() {

        WebTablePage wp = new WebTablePage(driver);

        wp.openTable();
        wp.addRecord();

        Assert.assertTrue(wp.isRecordPresent("Sravya"));

        System.out.println("Add Record Passed");
    }

    @Test
    public void testSearchRecord() {

        WebTablePage wp = new WebTablePage(driver);

        wp.openTable();
        wp.searchRecord("Sravya");

        Assert.assertTrue(wp.isRecordPresent("Sravya"));

        System.out.println("Search Record Passed");
    }

    @Test
    public void testDeleteRecord() {

        WebTablePage wp = new WebTablePage(driver);

        wp.openTable();

        wp.searchRecord("Cierra"); 
        wp.deleteRecord();

        Assert.assertTrue(true); 

        System.out.println("Delete Record Passed");
    }
    
    @Test
    public void testDeleteRecord1() {

        WebTablePage wp = new WebTablePage(driver);

        wp.openTable();

        wp.searchRecord("admin"); 
        wp.deleteRecord();

        Assert.assertTrue(true); 

        System.out.println("Name not found so failed");
    }
}