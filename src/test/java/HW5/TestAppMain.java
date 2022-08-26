package HW5;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;



public class TestAppMain extends AbstractTest {

    @Test
    void testCreatePost() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".s-header-item__link--post"))).click();


        WebElement webElement6 = getDriver().findElement(By.cssSelector(".\\_y6"));
        new WebDriverWait(getDriver(), 30).until(ExpectedConditions.elementToBeClickable(webElement6)).click();

        // js.executeScript("arguments[0].click()", webElement6);
        webElement6.sendKeys("Lorem");


        WebElement webElement7 = getDriver().findElement(By.cssSelector(".public-DraftStyleDefault-block"));
        js.executeScript("arguments[0].click()", webElement7);
        getDriver().findElement(By.cssSelector(".public-DraftStyleDefault-block")).sendKeys("Lorem ipsum");


        getDriver().findElement(By.cssSelector(".\\_129")).click();
        getDriver().findElement(By.cssSelector(".\\_124")).click();
        getDriver().findElement(By.cssSelector(".aentry-post__title-text")).click();

        //проверка  перехода на страницу созданного поста
        Assertions.assertEquals("Lorem: natalia6262 — ЖЖ", getDriver().getTitle(), "Не та страница");
        //проверка заполнения полей помощью getPageSource()
        Assertions.assertTrue(getDriver().getPageSource().contains("Lorem"), "Текст не найден");
        Assertions.assertTrue(getDriver().getPageSource().contains("Lorem ipsum"), "Текст не найден");
    }


    @Test
    void testUserAgree() {
        WebElement webElement5 = getDriver().findElement(By.cssSelector(".main-footer__bottom-links-item:nth-child(2) > .main-footer__bottom-link"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click()", webElement5);

        Assertions.assertEquals("https://www.livejournal.com/legal/tos-ru.bml", getDriver().getCurrentUrl(), "Не та страница");
    }

    @Test
    void testDraft(){
    new WebDriverWait(getDriver(), 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".s-header-item__link--post"))).click();
    getDriver().findElement(By.cssSelector(".\\_48 > .\\_49:nth-child(1)")).click();
    Assertions.assertEquals("https://www.livejournal.com/post/list", getDriver().getCurrentUrl(), "Не та страница");


}

}

