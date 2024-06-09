package Base;

import Utlies.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public  WebDriver driver;
    public static Properties prop ;
    public FileInputStream input = null;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        System.out.println("--------------------- BEFORE SUITE - STARTS ---------------------");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        prop = new Properties();
        input = new FileInputStream("config.properties");
        prop.load(input);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        System.out.println("--------------------- BEFORE SUITE - ENDS ---------------------");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("--------------------- AFTER SUITE - STARTS ---------------------");
        driver.quit();
        System.out.println("--------------------- AFTER SUITE - ENDS ---------------------");
    }
}
