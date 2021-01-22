package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ShopPage {
    private WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShopPage assertShopPageWithCurrentUrl() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://shop.kyivstar.ua/"));
        return this;
    }
}
