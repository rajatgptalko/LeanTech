package pageObjects;

import Utlies.ActionHelper;
import Utlies.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {

    private static CheckoutPage _instance;
    private final By Checkout = By.id("checkout");
    private final By card_list = By.xpath("//div[@data-test='cart-list']/div/div/a/div");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continue_btn = By.id("continue");

    private CheckoutPage() {

    }

    public static CheckoutPage getInstance() {
        if (_instance == null)
            _instance = new CheckoutPage();
        return _instance;
    }


    public List<String> getItemNamesOnCheckoutPage() {
        List<String> list = new ArrayList<>();
        List<WebElement> elementList = ActionHelper.findElements(card_list);
        for (WebElement item : elementList) {
            list.add(item.getText());
        }
        return list;

    }


    public void goToCheckout() {
        ActionHelper.click(Checkout);
        ExtentReport.test.log(Status.PASS, "Successfully Land on Checkout Page");
    }

    public void firstName(String input) {
        ActionHelper.sendKeys(firstName, input);
    }

    public void lastName(String input) {
        ActionHelper.sendKeys(lastName, input);
    }

    public void zipCode(String input) {
        ActionHelper.sendKeys(zipCode, input);
    }

    public void fillInformation(String firstName, String lastName, String code) {
        firstName(firstName);
        lastName(lastName);
        zipCode(code);
        ExtentReport.test.log(Status.PASS, "Successfully Filled all the details on checkout page");
    }

    public void clickContinueButton() {
        ActionHelper.click(continue_btn);
        ExtentReport.test.log(Status.PASS, "Successfully Land on Continue Button");
    }


}
