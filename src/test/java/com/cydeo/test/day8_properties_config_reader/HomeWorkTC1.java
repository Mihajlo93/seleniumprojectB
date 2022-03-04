package com.cydeo.test.day8_properties_config_reader;

import com.cydeo.Utilities.SmartBearUtils;
import com.cydeo.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWorkTC1 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
    }


    //3. Enter username: “Tester”
    //4. Enter password: “test”

    @Test
    public void test(){
        SmartBearUtils.loginToSmartBear(driver);
        //6. Print out count of all the links on landing page
        //7. Print out each link text on this page

        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
        System.out.println(allLinks.size());

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());

        }
    }

    @Test
    public void test2(){
        SmartBearUtils.loginToSmartBear(driver);
        //6. Click on Order
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();
        //7. Select familyAlbum from product, set quantity to 2
        Select productDropDown = new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));
        productDropDown.selectByVisibleText("FamilyAlbum");

        WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantity.sendKeys("2");
        //8. Click to “Calculate” button
        WebElement calculate = driver.findElement(By.xpath("//input[@type='submit']"));
        calculate.click();
        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();
        WebElement customer = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customer.sendKeys(faker.name().firstName()+" "+faker.name().lastName());

        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys(faker.address().streetName());

        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys(faker.address().city());

        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys(faker.address().state());

        WebElement zip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zip.sendKeys(faker.address().zipCode());

        //10. Click on “visa” radio button
        WebElement visaBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaBtn.click();
        Assert.assertTrue(visaBtn.isSelected());
        //11. Generate card number using JavaFaker
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumber.sendKeys(faker.number().digit()); //faker.business().creditCardNumber()
        WebElement expirationDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expirationDate.sendKeys("12/22"); //faker.business().creditCardExpiry()
        //12. Click on “Process”
        WebElement processBtn = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processBtn.click();
        //13. Verify success message “New order has been successfully added.”
        WebElement successfulOrderMessage = driver.findElement(By.xpath("//strong"));

        Assert.assertEquals(successfulOrderMessage.getText(), "New order has been successfully added.");
    }
}
