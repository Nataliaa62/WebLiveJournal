package HW6;

import org.example.HW6.PostPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostPageTest extends AbstractTest {

    @Test
    void createPostTest(){
        new PostPage(getWebDriver()).createPost("Lorem", "Lorem ipsum");
        Assertions.assertEquals("Lorem: natalia6262 — ЖЖ", getDriver().getTitle(), "Не та страница");
        Assertions.assertTrue(getDriver().getPageSource().contains("Lorem"), "Текст не найден");
        Assertions.assertTrue(getDriver().getPageSource().contains("Lorem ipsum"), "Текст не найден");

    }
    @Test
    void createDraftTest(){
        new PostPage(getWebDriver()).goToDraft();
        Assertions.assertEquals("https://www.livejournal.com/post/list", getDriver().getCurrentUrl(), "Не та страница");

    }
}
