package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // 1- set up the browser driver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        // 3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // Get current URL using Selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);


        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use Selenium to navigate back
        driver.navigate().back();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use Selenium to navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use Selenium to navigate refresh
        driver.navigate().refresh();

        //Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to():
        driver.navigate().to("https://www.google.com");



        //get the title of the page
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // Get current URL using Selenium
        currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        //this will close the currently opened window
        driver.close();

        //this will close all opened windows
        driver.quit();



    }
}
