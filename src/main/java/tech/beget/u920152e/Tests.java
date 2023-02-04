package tech.beget.u920152e;


import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {
    public static final WebDriver webDriver;
    public static final PageObject PAGE_OBJECT;
    public static WebDriverWait wait;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        PAGE_OBJECT = new PageObject(webDriver);

    }

    @Test
    public void TestSmoke() {
        PAGE_OBJECT.Start();
        Assert.assertTrue(PAGE_OBJECT.webDriver().findElement(By.className(PageObject.Avitorization)).isDisplayed());

    }
    @Test
    public void TestSmoke2(){
        PAGE_OBJECT.Start();
        webDriver.findElement(By.name(PageObject.Email)).sendKeys("vowkaz@inbox.ru");
        webDriver.findElement(By.name(PageObject.Password)).sendKeys("Test3123");
        webDriver.findElement(By.className(PageObject.Submit_Button)).click();
        Assert.assertTrue(webDriver.findElement(By.className(PageObject.Age)).isDisplayed());

    }
    @Test
    public void MailInputTest(){
        PAGE_OBJECT.Start();
        webDriver.findElement(By.name(PageObject.Email)).sendKeys("vowkazinbox.ru");
        webDriver.findElement(By.name(PageObject.Password)).sendKeys("Test3123");
        webDriver.findElement(By.className(PageObject.Submit_Button)).click();
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        WebElement field = webDriver.findElement(By.name(PageObject.Email));
        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", field);
        Assert.assertFalse(is_valid);
        }
    }




