package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MnpPage {
    private WebDriver driver;

    public MnpPage(WebDriver driver) {
        this.driver = driver;
    }

    public MnpPage assertMnpPageWithCurrentUrl() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://mnp.kyivstar.ua/"));
        return this;
    }
}
