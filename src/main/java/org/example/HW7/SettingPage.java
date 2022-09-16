package org.example.HW6;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SettingPage extends AbstractPage {


    @FindBy(css = ".b-menu-item:nth-child(3) > .b-menu-item-link")
    private WebElement buttonView;

    @FindBy(id = "LJ__Setting__Language_lang")
    private WebElement selectLang;

    @FindBy(css = ".b-service-inner-header > h3")
    private WebElement update;

    public SettingPage(WebDriver driver) {
        super(driver);
    }


    public void changeLangSettings() throws InterruptedException {
        this.buttonView.click();
        Thread.sleep(1000);
        Select selectObject = new Select(selectLang);
        selectObject.selectByValue("ru");
        this.buttonView.click();
        Thread.sleep(1000);
        // принятие алерта "Save of change?"
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }
}
