package HW7;


import io.qameta.allure.*;
import org.example.HW7.LoginPage;
import org.example.HW7.MainPage;
import org.example.HW7.SettingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;


public class XChangeLanguageTest extends AbstractTest {
   @Test
    @Order(1)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Смена языка")
    @Story("Смена языка через меню футера")
    @DisplayName("Тест-кейс №3: Проверка перехода сайта на англоязычную версию через меню футера")
    @Description("Проверка перехода сайта на англоязычную версию через меню футера")
    @Link("https://www.livejournal.com")
    @Issue("https://docs.google.com/spreadsheets/d/17yWg9T57tGjrkehtkuFVK8gxmsOOSGIVQYEyi0o5qMs/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void changeLangMainMenuTest() throws InterruptedException {
        Thread.sleep(1000);
        new MainPage(getWebDriver()).changeLangMainMenu();
        Thread.sleep(3000);
        assertTrue(new MainPage(getWebDriver()).checkLangOfTextHeader("POST NEW ENTRY","About","ENGLISH"));

    }

    @Test
    @Order(2)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Смена языка")
    @Story("Смена языка через меню настроек")
    @DisplayName("Тест-кейс №3: Проверка перехода сайта наанглозычную версию через настройки пользователя ")
    @Description("Проверка перехода сайта на англозычную версию через настройки пользователя ")
    @Link("https://www.livejournal.com")
    @Issue("https://docs.google.com/spreadsheets/d/17yWg9T57tGjrkehtkuFVK8gxmsOOSGIVQYEyi0o5qMs/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
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
