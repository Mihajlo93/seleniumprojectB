package com.cydeo.test.day5_testNG_intro_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void Test(){

        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearSelect.selectByVisibleText("1923");
        String yearSelectText = yearSelect.getFirstSelectedOption().getText();

        Assert.assertEquals(yearSelectText, "1923", "Year number doesnt match");

        Select monthSelect = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthSelect.selectByIndex(11);
        String monthSelectText = monthSelect.getFirstSelectedOption().getText();

        Assert.assertEquals(monthSelectText, "December", "Months doesnt match");

        Select daySelect = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        daySelect.selectByValue("1");
        String daySelectText = daySelect.getFirstSelectedOption().getText();

        Assert.assertEquals(daySelectText, "1", "Day doesn't match");




    }
    //TC #6: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select “December 1st, 1923” and verify it is selected.
    //Select year using  : visible text
    //Select month using   : value attribute
    //Select day using : index number
}
