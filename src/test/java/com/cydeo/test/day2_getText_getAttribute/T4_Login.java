package com.cydeo.test.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement emailAddress = driver.findElement(By.className("form-control"));
        emailAddress.sendKeys("incorrect@email.com");

        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("incorrect password");

        WebElement signIn = driver.findElement(By.tagName("button"));
        signIn.click();

    }
}
/*
TC #4: Library verifications
1. Open Chrome browser
2. Go to http://library2.cybertekschool.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password”
displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
 */