package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ServiceCentersListPage {
    private WebDriver driver;

    public ServiceCentersListPage(WebDriver driver) {
        this.driver = driver;
    }

    public ServiceCentersListPage assertServiceCentersListPageWithCurrentUrl() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://kyivstar.ua/uk/mm/service/centers/list"));
        return this;
    }
}
