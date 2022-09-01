package org.example.HW6;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {


    @FindBy(css = ".main-footer__bottom-links-item:nth-child(2) > .main-footer__bottom-link")
    private WebElement userAgree;


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void goToAgree() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", userAgree);

    }

}