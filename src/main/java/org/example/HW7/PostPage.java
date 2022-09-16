package org.example.HW7;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//заголовок поста
public class PostPage extends AbstractPage {
    @FindBy(css = ".text-0-2-176")
    private WebElement headerPost;
//основной текст поста
    @FindBy(css = ".public-DraftStyleDefault-block")
    private WebElement textPost;
//кнопка опубликовать
    @FindBy(css = ".backgroundBlue-0-2-104 > .rootIn-0-2-98")
    private WebElement buttonToPublic;
//кнопка некст
    @FindBy(css = ".rootMaxWidth-0-2-99 > .rootIn-0-2-98")
    private WebElement buttonNext;
//обновить
    @FindBy(css = ".aentry-post__title-text")
    private WebElement update;
//кнопка черновик
    @FindBy(css = ".rootStartFromBorder-0-2-247 > .item-0-2-248:nth-child(1)")
    private WebElement buttonDraft;


    public PostPage(WebDriver driver){
        super(driver);
    }

    public void createPost(String header, String text) throws InterruptedException {
       Thread.sleep(1000);
        headerPost.click();
        headerPost.sendKeys(header);
        textPost.click();
        textPost.sendKeys(text);
        buttonToPublic.click();
        buttonNext.click();
        update.click();
    }

    public void goToDraft() {
        buttonDraft.click();
    }
}
