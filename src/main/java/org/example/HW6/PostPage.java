package org.example.HW6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PostPage extends AbstractPage {

    @FindBy(css = ".s-header-item__link--post")
    private WebElement writePost;


    @FindBy(css = ".\\_y6")
    private WebElement headerPost;

    @FindBy(css = ".public-DraftStyleDefault-block")
    private WebElement textPost;


    @FindBy(css = ".\\_129")
    private WebElement buttonToPublic;


    @FindBy(css = ".\\_124")
    private WebElement buttonNext;

    @FindBy(css = ".aentry-post__title-text")
    private WebElement update;

    @FindBy(css = ".\\_48 > .\\_49:nth-child(1)")
    private WebElement buttonDraft;


    public PostPage(WebDriver driver){
        super(driver);
    }

    public void createPost(String header, String text) {
        writePost.click();
        headerPost.click();
        headerPost.sendKeys(header);
        textPost.click();
        textPost.sendKeys(text);
        buttonToPublic.click();
        buttonNext.click();
        update.click();
    }

    public void goToDraft() {
        writePost.click();
        buttonDraft.click();
    }
}
