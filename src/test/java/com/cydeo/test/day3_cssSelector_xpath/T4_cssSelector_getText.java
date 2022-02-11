package com.cydeo.test.day3_cssSelector_xpath;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T4_cssSelector_getText {

    public static void main(String[] args) {


        // TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        driver.manage().window().maximize();
        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
        //locating reset pass button using class attribute value ---button[value='Reset password']
        String actualResetPass = driver.findElement(By.cssSelector("button[class='login-btn")).getText();
        String expectedResetPass = "Reset password";
        if(actualResetPass.equals(expectedResetPass)){
            System.out.println("Reset password text PASSED!");
        }else {
            System.out.println("Reset password text FAILED!");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}