package pageObjects;

import Utlies.ActionHelper;
import Utlies.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;


public class LoginPage {
    private static LoginPage _instance;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By login_Btn = By.id("login-button");

    private LoginPage() {

    }

    public static LoginPage getInstance() {
        if (_instance == null)
            _instance = new LoginPage();
        return _instance;
    }


    public void setUsername(String input) {
        ActionHelper.sendKeys(username, input);
    }

    public void setPassword(String password_txt) {
        ActionHelper.sendKeys(password, password_txt);
    }

    public void clickLoginButton() {
        ActionHelper.click(login_Btn);
    }


    public void performLogin(String username, String password) throws InterruptedException {
        ExtentReport.test.log(Status.INFO, "Performing login on url");
        setUsername(username);
        setPassword(password);
        clickLoginButton();
        ExtentReport.test.log(Status.PASS, "Successfully logged IN");
       // Thread.sleep(5000);

    }
}
