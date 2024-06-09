package Utlies;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

}
