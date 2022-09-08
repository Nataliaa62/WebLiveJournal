package HW6;

import org.example.HW6.MainPage;
import org.example.HW6.PostPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostPageTest extends AbstractTest {


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
    void createDraftTest() throws InterruptedException {
        Thread.sleep(1000);
        new MainPage(getWebDriver()).clickBtnCreatePost();
        new PostPage(getWebDriver()).goToDraft();
        Assertions.assertEquals("https://www.livejournal.com/post/list", getWebDriver().getCurrentUrl(), "Не та страница");

    }






}
