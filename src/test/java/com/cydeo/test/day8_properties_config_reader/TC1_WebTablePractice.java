package com.cydeo.test.day8_properties_config_reader;

import com.cydeo.Utilities.WebDriverFactory;
import com.cydeo.Utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_WebTablePractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_nane_verify_test(){
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        Assert.assertEquals(bobMartinCell.getText(), "Bob Martin", "Name does not match");

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        WebElement bobMartinDateCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
        Assert.assertEquals(bobMartinDateCell.getText(), "12/31/2021", "Date does not match");

    }

    @Test
    public void test2(){
       String customerOrderDate1= WebTableUtils.returnOrderDate(driver, "Samuel Jackson");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

        String customerOrderDate2= WebTableUtils.returnOrderDate(driver, "John Doe");
        System.out.println("customerOrderDate2 = " + customerOrderDate2);
    }

    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver, "Samuel Jackson", "12/21/2021");
    }







        //
    }
