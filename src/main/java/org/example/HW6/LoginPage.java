package org.example.HW6;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoginPage extends MainPage {

    //поле ввода имя пользователя
    @FindBy(id = "user")
    private WebElement user;
    //поле ввода имя пароля
    @FindBy(id = "lj_loginwidget_password")
    private WebElement password;
    //кнопка "Войти"
    @FindBy(css = ".b-loginform-btn--auth")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public LoginPage loginIn(String user, String password) {

        Actions loginIn = new Actions(getDriver());
        loginIn
                .click(this.user)
                .sendKeys(this.user, user)
                .click(this.password)
                .sendKeys(this.password, password)
                .click(this.submit)
                .build()
                .perform();
        return new LoginPage(driver);
    }
}



