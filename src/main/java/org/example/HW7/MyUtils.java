package org.example.HW7;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class MyUtils {



    public static File makeScreenshot(WebDriver driver, String filename) {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./target/site" + filename);
        try {
            FileUtils.copyFile(temp, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return destination;
    }

 /*   public static File makeScreenshot(WebDriver driver, String filename) throws IOException {
        //создание скриншота с исп. интерфейса TakesScreenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      //  FileUtils.copyFile(screenshot, new File("./target/site" + filename));
        try {
            FileUtils.copyFile(screenshot, new File("./target/screenshot" + screenshot.getName()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return new File();
    }
*/

}
