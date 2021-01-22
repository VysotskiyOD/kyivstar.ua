package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MarketStoragePage {
    private WebDriver driver;

    public MarketStoragePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public MarketStoragePage assertGoogleLinkWithCurrentUrl() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://play.google.com/store/apps/details?id=com.kyivstar.mykyivstar&hl=uk"));
        return this;
    }

    public MarketStoragePage assertAppleLinkWithCurrentUrl() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://apps.apple.com/ua/app/my-kyivstar/id771788824"));
        return this;
    }
}
