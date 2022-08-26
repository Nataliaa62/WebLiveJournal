package HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {


   public static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }


    //записываем куки в файл для дальнейшего использования
    @BeforeAll
    static  void writeCookiesToFile() {

        driver.get("https://www.livejournal.com/");
    WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
    webElement1.click();

    WebElement webElement2 = driver.findElement(By.id("user"));
    webElement2.click();
    webElement2.sendKeys("natalia6262");

    WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
    webElement3.click();
    webElement3.sendKeys("2Ea035");

    WebElement webElement4 = driver.findElement(By.cssSelector(".b-loginform-btn--auth"));
    webElement4.click();

    File file = new File("coockieLiveJournal.dat");
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Cookie cookie : driver.manage().getCookies()) {
                writer.write((cookie.getName() + ";" + cookie.getValue()));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи куки - "+ e.getLocalizedMessage());
        }
    }


    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.livejournal.com/"),
                "Страница не доступна");
    }


    //для обращения к драйверу из класса. Добавляем куки из файла в драйвер
    public static WebDriver getDriver() {

        Cookie cookie = new Cookie("","");

        try {
            File file = new File("coockieLiveJournal.dat");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(line, ";");
                while (str.hasMoreTokens()) {
                    String name = str.nextToken();
                    String value = str.nextToken();

                    cookie = new Cookie(name, value);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка при чтении куки - "+ ex.getLocalizedMessage());
        }

     driver.manage().addCookie(cookie);

    return driver;
    }


    /*
    @AfterAll
    void quit() {
      driver.quit();
    }*/
}
