package org.example.HW7;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    //кнопка "Войти"
    @FindBy(css = ".s-header-item__link--login")
    private WebElement userEnter;
    //поле ввода имя пользователя
    @FindBy(id = "user")
    private WebElement user;
    //поле ввода имя пароля
    @FindBy(id = "lj_loginwidget_password")
    private WebElement password;
    //кнопка "Войти"
    @FindBy(css = ".b-loginform-btn--auth")
    private WebElement submit;

    //ссылка "о нас"
    @FindBy(css= ".main-footer__nav-link")
    private WebElement buttonAbout;
    //ссылка "Пользовательское соглашение"
    @FindBy(css = ".main-footer__bottom-links-item:nth-child(2) > .main-footer__bottom-link")
    private WebElement userAgree;
    //кнопка "Создать пост"
    @FindBy(css = ".s-header-item__link--post")
    private WebElement createPost;

    //выплывающий список "Выбрать язык"
    @FindBy(className = "label")
    private WebElement selectLangFooter;
    //значение в списке "выбрать язык" - английский
    @FindBy(xpath = ".//li[contains(.,'English')]")
    private WebElement valueEnglish;
    //обновление страницы
    @FindBy(css = ".main-footer__middle")
    private WebElement updateFooter;

    //кнопка "уведомления" (колокольчик)
    @FindBy(css = ".flaticon--bell > use")
    private WebElement buttonNotifications;
    //кнопка "Настройки"  в окне "Уведомление"
    @FindBy(css = ".notifications-header-link:nth-child(2)")
    private WebElement buttonSetup;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    //методы:
    // кликаем кнопку "Войти", метод возращает объект LoginPage
    public LoginPage clickBtnUserEnter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", this.userEnter);
        return new LoginPage(driver);
    }

    // кликнуть кнопку "Написать пост, метод возращает объект PostPage
    public PostPage clickBtnCreatePost() throws InterruptedException {
        Thread.sleep(1000);
        this.createPost.click();
        return new PostPage(driver);
    }


    //метод переход на Пользовательское соглашение
    public UserAgreePage goToAgree() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", userAgree);
        String fileName =  "test-case1-" + System.currentTimeMillis() + ".png";
        MyUtils.makeScreenshot(driver,fileName);
        return new UserAgreePage(driver);

    }

    //методы смены языка на "Английский" через меню футера
    public void changeLangMainMenu() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", selectLangFooter);
        js.executeScript("arguments[0].click()", valueEnglish);
        js.executeScript("arguments[0].click()", updateFooter);

    }
    //проверка смены языка
    public Boolean checkLangOfTextHeader(String LangOfTextHeader, String LangOfTextFooter, String SelectLang){
        String a = createPost.getText();
        String b = buttonAbout.getText();
        String c = selectLangFooter.getText();
        return a.equals(LangOfTextHeader)& b.equals(LangOfTextFooter) & c.equals(SelectLang);
    }

    //кликнуть кнопку Уведомления
    public MainPage clickNotifications() throws InterruptedException {
        Thread.sleep(2000);
        this.buttonNotifications.click();
        return this;
    }
    //кликнуть кнопку Уведомления/Настройки
    public MainPage clickNotificationsSetup() {
        this.buttonSetup.click();
        return this;
    }
}

