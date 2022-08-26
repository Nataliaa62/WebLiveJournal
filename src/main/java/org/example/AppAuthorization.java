package org.example;

// эту зависимость прописали в пом
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;


public class AppAuthorization {
    public static void main( String[] args ) {

      /*  WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        driver.get("https://www.livejournal.com/");*/


        readCookiesFromFileff();
        readCookiesFromFile();


       /* WebElement webElement1 = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();


        WebElement webElement2 = driver.findElement(By.id("user"));
        webElement2.click();
        webElement2.sendKeys("natalia6262");


        WebElement webElement3 = driver.findElement(By.id("lj_loginwidget_password"));
        webElement3.click();
        webElement3.sendKeys("2Ea035");


        WebElement webElement4 = driver.findElement(By.cssSelector(".b-loginform-btn--auth"));
        webElement4.click();


        *//*Cookie cookie = new Cookie("key", "value");
        driver.manage().addCookie(cookie);
        System.out.println(cookie);*//*
        File file = new File("browser.dat");
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Cookie cookie : driver.manage().getCookies()) {
                writer.write((cookie.getName() + ";" + cookie.getValue() + ";" +
                        cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() +
                        ";" + cookie.isSecure()));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи куки - "+ e.getLocalizedMessage());
        }
*/
      //  driver.quit();
    }


    public static void readCookiesFromFileff(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

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


    /*Cookie cookie = new Cookie("key", "value");
    driver.manage().addCookie(cookie);
    System.out.println(cookie);*/
    File file = new File("browser.dat");
        try {
    file.createNewFile();
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    for (Cookie cookie : driver.manage().getCookies()) {
        writer.write((cookie.getName() + ";" + cookie.getValue() + ";" +
                cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() +
                ";" + cookie.isSecure()));
        writer.newLine();
    }
    writer.flush();
    writer.close();
} catch (IOException e) {
    System.out.println("Ошибка при записи куки - "+ e.getLocalizedMessage());
}

    //  driver.quit();
}

    public static Cookie readCookiesFromFile() {
        Cookie cookie = new Cookie("","");
        try {
            File file = new File("browser.dat");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(line, ";");
                while (str.hasMoreTokens()) {
                    String name = str.nextToken();
                    String value = str.nextToken();
                    String domain = str.nextToken();
                    String path = str.nextToken();
                    Date expiry = null;
                    String date= str.nextToken();
                    if (!(date).equals("null")) {
                        expiry = new Date(System.currentTimeMillis()*2);
                    }
                    boolean isSecure = new Boolean(str.nextToken()).booleanValue();
                    cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                    System.out.println(cookie);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка при чтении куки - "+ ex.getLocalizedMessage());
        }
        // return cookie;
        return cookie;
    }


}
