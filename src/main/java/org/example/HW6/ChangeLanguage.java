package org.example.HW6;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ChangeLanguage extends AbstractPage {

    @FindBy(css = ".flaticon--bell > use")
    private WebElement buttonNotifications;

    @FindBy(css = ".notifications-header-link:nth-child(2)")
    private WebElement buttonSetup;

    @FindBy(css = ".b-menu-item:nth-child(3) > .b-menu-item-link")
    private WebElement buttonView;

    @FindBy(id = "LJ__Setting__Language_lang")
    private WebElement selectLang;

    @FindBy(css= ".b-service-inner-header > h3")
    private WebElement update;

    @FindBy(css= ".s-header-item-post--long")
    private WebElement writePost;

    @FindBy(css= ".main-footer__nav-link")
    private WebElement buttonAbout;


    @FindBy(className = "label")
    private WebElement selectLangFooter;
    @FindBy(xpath = ".//li[contains(.,'English')]")
    private WebElement valueEnglish;
    @FindBy(css = ".main-footer__middle")
    private WebElement updateFooter;


    public ChangeLanguage(WebDriver driver){
            super(driver);
        }

    public void changeLangSettings(){
        this.buttonNotifications.click();
        this.buttonSetup.click();
        this.buttonView.click();
        Select selectObject = new Select(selectLang);
        selectObject.selectByValue("en_LJ");
        this.update.click();

        Assertions.assertTrue(writePost.getText().contains ("POST NEW ENTRY"), "Смена языка не произошла");
        Assertions.assertTrue(buttonAbout.getText().contains ("About"), "Смена языка не произошла");

    }

    public void changeLangMainMenu() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", selectLangFooter);
        js.executeScript("arguments[0].click()", valueEnglish);
        js.executeScript("arguments[0].click()", updateFooter);


        //проверка  смены выбранного языка в поле "Выбрать язык"
        Assertions.assertTrue(selectLangFooter.getText().contains("ENGLISH"), "Смена языка не произошла");
        //Проверка смены языка в меню хедера
        Assertions.assertTrue(buttonAbout.getText().contains("POST NEW ENTRY"), "Смена языка не произошла");
        //Проверка смены языка в меню футера
        Assertions.assertTrue(buttonAbout.getText().contains("About"), "Смена языка не произошла");

    }
}


