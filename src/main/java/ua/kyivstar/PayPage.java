package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PayPage {
    private WebDriver driver;

    public PayPage(WebDriver driver) {
        this.driver = driver;
    }

    public PayPage assertPayPageWithCurrentUrl() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://pay.kyivstar.ua"));
        return this;
    }
}
