package HW6;


import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.HW6.LoginPage;
import org.example.HW6.MainPage;
import org.example.HW6.SettingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;



public class ChangeLanguageTest extends AbstractTest {
    @Test
    @Order(1)
    void changeLangMainMenuTest() throws InterruptedException {
        Thread.sleep(1000);
        new MainPage(getWebDriver()).changeLangMainMenu();
        Thread.sleep(3000);
        assertTrue(new MainPage(getWebDriver()).checkLangOfTextHeader("POST NEW ENTRY","About","ENGLISH"));

    }

    @Test
    @Order(2)
    void changeLangSettingsTest() throws InterruptedException {
        Thread.sleep(1000);
        new MainPage(getWebDriver())
                .clickNotifications()
                .clickNotificationsSetup();
        new SettingPage(getWebDriver()).changeLangSettings();
        assertTrue(new MainPage(getWebDriver()).checkLangOfTextHeader(
                "НАПИСАТЬ В БЛОГ",
                "О проекте",
                "РУССКИЙ"));
    }


}
