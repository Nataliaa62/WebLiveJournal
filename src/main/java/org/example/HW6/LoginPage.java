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

public class LoginPage extends AbstractPage {


       @FindBy(id = "user")
       private WebElement user;

       @FindBy(id = "lj_loginwidget_password")
       private WebElement password;

       @FindBy(css = ".b-loginform-btn--auth")
       private WebElement submit;

        public LoginPage(WebDriver driver){
            super(driver);

        }

    public void loginIn(String user, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn
                .click(this.user)
                .sendKeys(this.user,user)
                .click(this.password)
                .sendKeys(this.password,password)
                .click(this.submit)
                .build()
                .perform();

        File file = new File("coockieLiveJournal.dat");
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Cookie cookie : driver.manage().getCookies()) {
                writer.write((cookie.getName() + ";" + cookie.getValue()));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи куки - "+ e.getLocalizedMessage());
        }
    }

}

