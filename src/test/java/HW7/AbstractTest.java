package HW7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.example.HW7.LoginPage;
import org.example.HW7.MainPage;
import org.example.HW7.MyUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

        static WebDriver webDriver;

        @BeforeAll
        static void setDriver(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.get("https://www.livejournal.com/");
        }


  @BeforeAll
static void  writeCookiesToFile() {

      getWebDriver().get("https://www.livejournal.com/");
      Assertions.assertEquals("https://www.livejournal.com/", getWebDriver().getCurrentUrl(), "Не та страница");
      new MainPage(getWebDriver()).clickBtnUserEnter();
      new LoginPage(getWebDriver()).loginIn("natalia6262", "2Ea035");


        File file = new File("coockieLiveJournal.dat");
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Cookie cookie : webDriver.manage().getCookies()) {
                writer.write((cookie.getName() + ";" + cookie.getValue()));
                writer.newLine();
            }
    writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи куки - "+ e.getLocalizedMessage());
        }
    }

    //для обращения к драйверу из класса. Добавляем куки из файла в драйвер

   @BeforeEach
   public void getDriver() {
    getWebDriver().get("https://www.livejournal.com/");
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
        webDriver.manage().addCookie(cookie);
        }

    @AfterEach
    public void makeScreenshot() {
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
    //File file = MyUtils.makeScreenshot(getWebDriver(),"failure- org.example.bbc.MyShowTest.testFalse" + System.currentTimeMillis() + ".png"

    try {
        FileUtils.copyFile(screenshot, new File("./target/screenshot" + System.currentTimeMillis() + ".png"));
    } catch (IOException exception) {
        exception.printStackTrace();
    }
        }



/*
 @AfterEach
        void exit(){

            if(webDriver !=null) webDriver.quit();
        }
*/

    public static WebDriver getWebDriver(){
            return webDriver;
        }
}

