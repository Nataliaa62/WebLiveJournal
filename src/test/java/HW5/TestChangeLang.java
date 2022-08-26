package HW5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestChangeLang extends AbstractTest {

    @Test
    void testLangSettings() {

        WebElement webElement1 = getDriver().findElement(By.cssSelector(".flaticon--bell > use"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".notifications-header-link:nth-child(2)"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".b-menu-item:nth-child(3) > .b-menu-item-link"));
        webElement3.click();
        WebElement webElement4 = getDriver().findElement(By.id("LJ__Setting__Language_lang"));
        webElement4.click();


        Select selectObject = new Select(webElement4);
        selectObject.selectByValue("en_LJ");

        WebElement webElement5 = getDriver().findElement(By.cssSelector(".b-service-inner-header > h3"));
        webElement5.click();

        //проверка  смены выбранного языка в поле "Язык"
        Assertions.assertTrue(webElement4.getText().contains("English"), "Смена языка не произошла");

        //Проверка смены языка в меню хедера
        WebElement webElement9 = getDriver().findElement(By.cssSelector(".s-header-item-post--long"));
        Assertions.assertTrue(webElement9.getText().contains ("POST NEW ENTRY"), "Смена языка не произошла");

        //Проверка смены языка в меню футера
        WebElement webElement10 = getDriver().findElement(By.cssSelector(".main-footer__nav-link"));
        Assertions.assertTrue(webElement10.getText().contains ("About"), "Смена языка не произошла");


    }


    @Test
    void testLangMainMenu() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Thread.sleep(2000);
        WebElement webElement6 = getDriver().findElement(By.className("label"));
        js.executeScript("arguments[0].click()", webElement6);


        WebElement webElement7 = getDriver().findElement(By.xpath(".//li[contains(.,'English')]"));
        js.executeScript("arguments[0].click()", webElement7);


        WebElement webElement8 = getDriver().findElement(By.cssSelector(".main-footer__middle"));
        js.executeScript("arguments[0].click()", webElement8);


        //проверка  смены выбранного языка в поле "Выбрать язык"
        Assertions.assertTrue(webElement6.getText().contains("ENGLISH"), "Смена языка не произошла");

        //Проверка смены языка в меню хедера
        WebElement webElement9 = getDriver().findElement(By.cssSelector(".s-header-item-post--long"));
        Assertions.assertTrue(webElement9.getText().contains ("POST NEW ENTRY"), "Смена языка не произошла");

        //Проверка смены языка в меню футера
        WebElement webElement10 = getDriver().findElement(By.cssSelector(".main-footer__nav-link"));
        Assertions.assertTrue(webElement10.getText().contains ("About"), "Смена языка не произошла");

    }
}
