package com.cydeo.test.day6_alerts_iframes_windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_AlertPractices {

    //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void test_1(){
        //3. Click to “Click for JS Alert” button
        WebElement jsAlertClick = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertClick.click();
        //4. Click to OK button from the alert
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        String verifyMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(verifyMessage, "You successfully clicked an alert", "Verify message mismatch");
    }


    @Test
    public void test_2(){
        //3. Click to “Click for JS Confirm” button
        WebElement jsButtonClick = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsButtonClick.click();
        //4. Click to OK button from the alert
        Alert jsComfirmAlert = driver.switchTo().alert();
        jsComfirmAlert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        String verifyMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(verifyMessage, "You clicked: Ok", "Verify message mismatch");
    }

    @Test
    public void test_3() throws InterruptedException {
        //. Click to “Click for JS Prompt” button
        WebElement jsButtonClick = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsButtonClick.click();
        //4. Send “hello” text to alert
        Alert jsComfirmAlert = driver.switchTo().alert();
        jsComfirmAlert.sendKeys("hello");
        Thread.sleep(3000);
        //5. Click to OK button from the alert
        jsComfirmAlert.accept();
        //6. Verify “You entered:  hello” text is displayed.
        String verifyText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(verifyText, "You entered:  hello", "Verify message mismatch");
    }




}
