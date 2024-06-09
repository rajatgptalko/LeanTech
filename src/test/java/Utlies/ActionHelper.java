package Utlies;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActionHelper {


    public static boolean isPresent(By by, int waitTimeMillis, WebDriver driver) throws InterruptedException {
        boolean flag = false;
        int i = 0;
        while (i < (waitTimeMillis / 1000) * 2) {
            if (isPresent(by, driver)) {
                flag = true;
                break;
            }
            Thread.sleep(500);
            i++;
        }
        return flag;
    }

    private static boolean isPresent(By by, WebDriver driver) {
        boolean flag = false;
        if (!driver.findElements(by).isEmpty()) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    flag = true;
                }
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }

    public static void waitUntilElementsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(4000));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static WebElement findElement(By by) {
        waitUntilElementsVisible(by);
        return DriverManager.getDriver().findElement(by);
    }
    public static List<WebElement> findElements(By by) {
        waitUntilElementsVisible(by);
        return DriverManager.getDriver().findElements(by);
    }

    public static void click(By by) {
        findElement(by).click();
        ExtentReport.test.log(Status.PASS, "Successfully click on  "+by.toString());
    }

    public static String getAttribute(By by) {
        findElement(by).getText();
        ExtentReport.test.log(Status.PASS, "Getting attribute  "+by.toString());
        return findElement(by).getText();
    }


    public static void sendKeys(By by, String input) {
        if (input.isEmpty())
            return;
        findElement(by).sendKeys(input);
        ExtentReport.test.log(Status.PASS, "Successfully filled value in text field "+by.toString());

    }
}
