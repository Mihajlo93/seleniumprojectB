package com.cydeo.test.day3_cssSelector_xpath;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T2_getText_getAttribute {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        String rememberMe = driver.findElement(By.className("login-item-checkbox-label")).getText();
        String expectedRememberMe = "Remember me on this computer";

        if(rememberMe.equals(expectedRememberMe)){
            System.out.println("Remember me verification PASSED!");
        }else {
            System.out.println("Remember me verification FAILED!");
        }

        String forgotPassword = driver.findElement(By.className("login-link-forgot-pass")).getText();
        String expectedForgotPassword = "Forgot your password?";


        if(forgotPassword.equals(expectedForgotPassword)){
            System.out.println("Forgot password verification PASSED!");
        }else {
            System.out.println("Forgot password verification FAILED!");
        }

        String forgotPasswordAtt = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");
        String expectedForgotPassAtt = "forgot_password=yes";

        if(forgotPasswordAtt.contains(expectedForgotPassAtt)){
            System.out.println("Forgot password attribute verification PASSED!");
        }else {
            System.out.println("Forgot password attribute verification FAILED!");
        }
    }
}
/*
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes

 PS: Inspect and decide which locator you should be using to locate web
elements.
 */