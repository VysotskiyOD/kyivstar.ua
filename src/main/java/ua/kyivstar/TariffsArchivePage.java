package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TariffsArchivePage {
    private WebDriver driver;
    private final String titleArchivePage = "Архів тарифів від Київстар | Національний оператор мобільного зв'язку";

    public TariffsArchivePage(WebDriver driver) {
        this.driver = driver;
    }

    public TariffsArchivePage assertThanTariffsArchivePage() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("https://kyivstar.ua/uk/mm/tariffs/arhive"));
        return this;
    }

    public TariffsArchivePage assertTitleTariffsArchivePage() {
        Assert.assertTrue(driver.getTitle().contentEquals(titleArchivePage));
        System.out.println(driver.getTitle());
        return this;
    }
}
