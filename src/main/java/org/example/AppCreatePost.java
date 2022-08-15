package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppCreatePost {

    public static void main( String[] args ) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");


        WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();

        WebElement webElement2 = driver.findElement(By.id("user"));
        webElement2.click();
        webElement2.sendKeys("natalia6262");


        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement3.click();
        webElement3.sendKeys("2Ea035");

        WebElement webElement4 = driver.findElement(By.xpath(".//button[@name='action:login']"));
        webElement4.click();


        WebElement webElement5 = driver.findElement(By.cssSelector(".s-header-item__link--post"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", webElement5);



        WebElement webElement6 = driver.findElement(By.cssSelector(".\\_y6"));
        js.executeScript("arguments[0].click()", webElement6);
        webElement6.sendKeys("Lorem");




        WebElement webElement7 = driver.findElement(By.cssSelector(".public-DraftStyleDefault-block"));
        js.executeScript("arguments[0].click()", webElement7);
        driver.findElement(By.cssSelector(".public-DraftStyleDefault-block")).sendKeys("Lorem ipsum");


        //другой синтаксис
        driver.findElement(By.cssSelector(".\\_129")).click();
        driver.findElement(By.cssSelector(".\\_124")).click();
        driver.findElement(By.cssSelector(".aentry-post__title-text")).click();


    
        driver.quit();
    }
}
