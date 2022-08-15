package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppUserAgree {

    public static void main( String[] args ) {
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");


    WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();


    WebElement webElement2 = driver.findElement(By.id("user"));
        webElement2.click();
        webElement2.sendKeys("natalia6262");


    WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement3.click();
        webElement3.sendKeys("2Ea035");


    WebElement webElement4 = driver.findElement(By.cssSelector(".b-loginform-btn--auth"));
        webElement4.click();


    WebElement webElement5 = driver.findElement(By.xpath("//a[contains(text(),'Пользовательское соглашение')]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", webElement5);

        driver.quit();
    }
}
