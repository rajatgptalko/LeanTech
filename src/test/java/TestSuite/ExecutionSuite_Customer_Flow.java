package TestSuite;

import Base.BaseTest;
import Utlies.TestGroup;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.OverviewPage;
import pageObjects.SwagLabsProductsPage;

public class ExecutionSuite_Customer_Flow extends BaseTest {


    @Test(groups = TestGroup.CHECKOUT)
    public void TC_CustomerFlow01_verify_items_checkout_flow() throws InterruptedException {
        String product_1 = prop.getProperty("product_1");
        String product_2 = prop.getProperty("product_2");
        String product_3 = prop.getProperty("product_3");
        LoginPage.getInstance().performLogin(prop.getProperty("userName"), prop.getProperty("password"));
        SwagLabsProductsPage.getInstance().addProductsToBasket(product_1);
        SwagLabsProductsPage.getInstance().addProductsToBasket(product_2);
        SwagLabsProductsPage.getInstance().addProductsToBasket(product_3);
        SwagLabsProductsPage.getInstance().goToBasket();
        SoftAssert softAssert = new SoftAssert();
        //Validate items on checkout page
        softAssert.assertEquals(CheckoutPage.getInstance().getItemNamesOnCheckoutPage().get(0), product_1);
        softAssert.assertEquals(CheckoutPage.getInstance().getItemNamesOnCheckoutPage().get(1), product_2);
        softAssert.assertEquals(CheckoutPage.getInstance().getItemNamesOnCheckoutPage().get(2), product_3);

        CheckoutPage.getInstance().goToCheckout();
        CheckoutPage.getInstance().fillInformation(prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("zipCode"));
        CheckoutPage.getInstance().clickContinueButton();

        //Validate items on Overview page
        softAssert.assertEquals(OverviewPage.getInstance().getItemNamesOverviewPage().get(0), product_1);
        softAssert.assertEquals(OverviewPage.getInstance().getItemNamesOverviewPage().get(1), product_2);
        softAssert.assertEquals(OverviewPage.getInstance().getItemNamesOverviewPage().get(2), product_3);

        OverviewPage.getInstance().clickFinishButton();

        //validate Success Page
        softAssert.assertEquals(OverviewPage.getInstance().getSuccessText(), "Thank you for your order!");
        softAssert.assertAll();

    }
}
