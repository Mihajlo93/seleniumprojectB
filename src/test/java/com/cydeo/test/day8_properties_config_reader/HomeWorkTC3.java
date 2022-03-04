package com.cydeo.test.day8_properties_config_reader;

import com.cydeo.Utilities.SmartBearUtils;
import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWorkTC3 {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

    }
    @Test
    public void test(){
        //1. Open browser and login to Smartbear software
        SmartBearUtils.loginToSmartBear(driver);
        //2. Click on View all orders
        WebElement allOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        allOrders.click();
        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susanCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Susan McLaren']"));

        WebElement dateCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Susan McLaren']//following-sibling::td[3]"));

        Assert.assertEquals(dateCell.getText(), "01/05/2010", "Date does not match");
    }
}