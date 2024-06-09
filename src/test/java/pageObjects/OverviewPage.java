package pageObjects;

import Utlies.ActionHelper;
import Utlies.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OverviewPage {

    private static OverviewPage _instance;
    private final By card_list = By.xpath("//div[@data-test='cart-list']/div/div/a/div");
    private final By finish_btn = By.id("finish");
    private final By successOrder = By.xpath("//h2[@data-test='complete-header']");

    private OverviewPage() {

    }

    public static OverviewPage getInstance() {
        if (_instance == null)
            _instance = new OverviewPage();
        return _instance;
    }


    public List<String> getItemNamesOverviewPage() {
        List<String> list = new ArrayList<>();
        List<WebElement> elementList = ActionHelper.findElements(card_list);
        for (WebElement item : elementList) {
            list.add(item.getText());
        }
        return list;

    }
    public void clickFinishButton() {
        ActionHelper.click(finish_btn);
        ExtentReport.test.log(Status.PASS, "Successfully Land on Finish Button");
    }

    public String getSuccessText() {
        return ActionHelper.getAttribute(successOrder);

    }


}
