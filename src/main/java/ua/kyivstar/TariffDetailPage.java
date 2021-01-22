package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TariffDetailPage {
    private WebDriver driver;

    public TariffDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public TariffDetailPage assertTariffsInfoWithDetailPage() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("http://beta.kyivstar.ua/"));
        return this;
    }

}
