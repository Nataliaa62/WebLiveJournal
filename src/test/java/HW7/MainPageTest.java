package HW7;

import io.qameta.allure.*;
import org.example.HW7.MainPage;
import org.example.HW7.MyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MainPageTest extends AbstractTest {

@Test

@Epic("Тестирование интерфейса сайта")
@DisplayName("Тест-кейс №3: Переход на пользовательское соглашение")
@Description("Проверка работоспособности ссылки \"Пользовательское соглашение\"")
@Link("https://www.livejournal.com")
@Issue("https://docs.google.com/spreadsheets/d/17yWg9T57tGjrkehtkuFVK8gxmsOOSGIVQYEyi0o5qMs/edit?usp=sharing")
@Severity(SeverityLevel.MINOR)
void toGoUserAgreeTest() {
    new MainPage(getWebDriver()).goToAgree();
   Assertions.assertEquals("https://www.livejournal.com/legal/tos-ru.bml", getWebDriver().getCurrentUrl(), "Не та страница");

}
}
