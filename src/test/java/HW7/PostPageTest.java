package HW7;

import io.qameta.allure.*;
import org.example.HW7.MainPage;
import org.example.HW7.PostPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostPageTest extends AbstractTest {

   @Epic("Тестирование интерфейса сайта")
    @DisplayName("Тест-кейс №3: Создание поста зарегистированным пользователем")
    @Description("Создание поста зарегистированным пользователем")
    @Link("https://www.livejournal.com")
    @Issue("https://docs.google.com/spreadsheets/d/17yWg9T57tGjrkehtkuFVK8gxmsOOSGIVQYEyi0o5qMs/edit?usp=sharing")
    @Severity(SeverityLevel.CRITICAL)
  @Test
    void createPostTest() throws InterruptedException {
Thread.sleep(1000);
        new MainPage(getWebDriver()).clickBtnCreatePost();
        new PostPage(getWebDriver()).createPost("Lorem", "Lorem ipsum");
        Thread.sleep(1000);
        Assertions.assertEquals("Lorem: natalia6262 — ЖЖ", getWebDriver().getTitle(), "Не та страница");
        Assertions.assertTrue(getWebDriver().getPageSource().contains("Lorem"), "Текст не найден");
        Assertions.assertTrue(getWebDriver().getPageSource().contains("Lorem ipsum"), "Текст не найден");
    }


    @Test
    @Epic("Тестирование интерфейса сайта")
    @DisplayName("Тест-кейс №3: Проверка перехода на страницу \"Черновики\"")
    @Description("Проверка перехода на страницу \"Черновики\"")
    @Link("https://www.livejournal.com")
    @Issue("https://docs.google.com/spreadsheets/d/17yWg9T57tGjrkehtkuFVK8gxmsOOSGIVQYEyi0o5qMs/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void createDraftTest() throws InterruptedException {
        Thread.sleep(1000);
        new MainPage(getWebDriver()).clickBtnCreatePost();
        new PostPage(getWebDriver()).goToDraft();
        Assertions.assertEquals("https://www.livejournal.com/post/list", getWebDriver().getCurrentUrl(), "Не та страница");

    }
}
