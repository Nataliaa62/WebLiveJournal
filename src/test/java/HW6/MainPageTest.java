package HW6;

import org.example.HW6.LoginPage;
import org.example.HW6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


    public class MainPageTest extends AbstractTest {


        @Test
        void toGoUserAgreeTest() {
            new MainPage(getWebDriver()).goToAgree();
            Assertions.assertEquals("https://www.livejournal.com/legal/tos-ru.bml", getDriver().getCurrentUrl(), "Не та страница");
        }

    }
