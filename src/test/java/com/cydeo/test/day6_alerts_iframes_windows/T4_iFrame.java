package com.cydeo.test.day6_alerts_iframes_windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_iFrame {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
        //3. Go to: https://practice.cydeo.com/iframe


    }
    @Test
    public void test_1(){
        // We need to switch drivers focus to iframe
        // option #1 - switching to iframe using id attribute value
        driver.switchTo().frame("mce_0_ifr");
        // option #2 - switching to iframe using index value
        //driver.switchTo().frame(0);

        //option #3 - locate as web element and pass in frame() method
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));


        //4. Assert: “Your content goes here.” Text is displayed.
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        //To be able to verify header, we must switch back to "main HTML"
        driver.switchTo().parentFrame();

        String verifyHeader = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(verifyHeader, "An iFrame containing the TinyMCE WYSIWYG Editor", "Header text is not matching");

    }


}