package com.cydeo.test.day6_alerts_iframes_windows;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
        //3. Go to : https://practice.cydeo.com/windows
    }

    @Test
    public void test_1() {
        // Storing the handle of the main window
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);
        //4. Assert: Title is “Windows”
        String verifyTitle = driver.getTitle();
        Assert.assertEquals(verifyTitle, "Windows", "Title is not matching");
        System.out.println("Title before click: "+verifyTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();

        //6. Switch to new Window.
        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("Current title while switching windowss: "+driver.getTitle());
        }
        //7. Assert: Title is “New Window”
        verifyTitle=driver.getTitle();
        System.out.println("Title after click = " + verifyTitle);
        String expectedTitleAfterClick = "New Window";

        Assert.assertEquals(verifyTitle, expectedTitleAfterClick);

    }

    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }





}
