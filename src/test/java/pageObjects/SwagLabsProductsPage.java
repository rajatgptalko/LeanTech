package pageObjects;

import Utlies.ActionHelper;
import Utlies.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;


public class SwagLabsProductsPage {

    private static SwagLabsProductsPage _instance;
    String productAddToCart = "//*[text()='xyz']/../../../div[2]/div/following-sibling::button";
    private final By basketIcon = By.xpath("//*[@id='shopping_cart_container']/a/span[@class='shopping_cart_badge']");

    private SwagLabsProductsPage() {

    }

    public static SwagLabsProductsPage getInstance() {
        if (_instance == null)
            _instance = new SwagLabsProductsPage();
        return _instance;
    }

    public void addProductsToBasket(String productName) {
        By by = By.xpath(productAddToCart.replace("xyz", productName));
        ActionHelper.click(by);
        ExtentReport.test.log(Status.INFO, "Product Successfully Added  to basket "+productName);
    }

    public void goToBasket() {
        ActionHelper.click(basketIcon);
        ExtentReport.test.log(Status.INFO, "Successfully Land on Basket Page");
    }


}
