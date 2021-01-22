package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage assertLoginPageWithCurrentUrl() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://account.kyivstar.ua/cas/login"));
        return this;
    }
}
