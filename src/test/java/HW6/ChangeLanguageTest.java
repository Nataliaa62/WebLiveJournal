package HW6;


import org.example.HW6.ChangeLanguage;
import org.junit.jupiter.api.Test;


public class ChangeLanguageTest extends AbstractTest {

    @Test
    void changeLangSettingsTest(){
        new ChangeLanguage(getWebDriver()).changeLangSettings();

    }

    @Test
    void changeLangMainMenTest(){
        new ChangeLanguage(getWebDriver()).changeLangMainMenu();
    }
}
