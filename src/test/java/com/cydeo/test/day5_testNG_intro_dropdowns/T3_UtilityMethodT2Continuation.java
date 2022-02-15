package com.cydeo.test.day5_testNG_intro_dropdowns;

import com.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_UtilityMethodT2Continuation {
    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));

        //locate name='sports' radio buttons and store them in a List of Web Element
        List<WebElement> sportRadioButtons = driver.findElements(By.name("sport"));

        //Loop through the List of WebElement and select matching result "hockey"
        for (WebElement each : sportRadioButtons) {
            String eachId = each.getAttribute("id");
            System.out.println("eachId = "+eachId);
            if(eachId.equals("football")){
                each.click();
                System.out.println("Hockey is selected: "+each.isSelected());
                break;
            }

        }
        clickAndVerifyRadioButton(driver, "sport", "basketball");
    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue){
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {
            String eachId= each.getAttribute("id");

            if(eachId.equals(idValue)){
                each.click();
                System.out.println(eachId+" is selected :"+each.isSelected());
                break;
            }

        }
    }
}
/*
TC #3: Utility method task for (continuation of Task2)
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */