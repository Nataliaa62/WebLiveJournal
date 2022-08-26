package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

public class AppChangeLang {
    public static void main( String[] args ) {

        // зарегистировали драйвер (хром)
        WebDriverManager.chromedriver().setup();
        //добавили опции, необязательно
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");


        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();

        WebElement webElement2 = driver.findElement(By.id("user"));
        webElement2.click();
        webElement2.sendKeys("natalia6262");


        WebElement webElement4 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement4.click();
        webElement4.sendKeys("2Ea035");

        WebElement webElement5 = driver.findElement(By.cssSelector(".b-loginform-btn--auth"));
        webElement5.click();

        
        //Возник ElementClickInterceptedException. ExpectedConditions не помог.Гугл:
        //Когда ожидания не помогают, м.исп. JavascriptExecutor для операции
        // щелчкa(ключевой интерфейс для запуска JavaScript странице браузера с помощью Selenium WebDriver.

        WebElement webElement6 = driver.findElement(By.name("lang"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", webElement6);

        Select selectObject = new Select(webElement6);
        selectObject.selectByVisibleText("English");

       /*WebElement webElement7 = driver.findElement(By.xpath(".//li[contains(.,'English')]"));
       js.executeScript("arguments[0].click()", webElement7);*/


        WebElement webElement8 = driver.findElement(By.cssSelector(".main-footer__middle"));
        webElement8.click();

        // driver.quit();
    }
}
