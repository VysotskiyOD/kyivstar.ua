package kyivstar.ua;

import org.junit.Test;
import ua.kyivstar.*;

public class TariffsTest extends BaseTest {

    @Test
    public void WhenPageOpenThenAssertUrl() {

        new TariffsPage(driver).assertThanTariffsPage();
    }

    @Test
    public void WhenPageOpenThenAssertTitle() {

        new TariffsPage(driver).assertTitleTariffsPage();
    }

    @Test
    public void WhenTariffsPageOpenClickFilterPrepaidThenAssertDisableFilterPostpaid() {
        new TariffsPage(driver).clickOnFilterPrepaid()
                .checkedEnabledFilterPrepaidAndDisablePostpaid()
                .assertSelectFiltersWithTariffs();
    }

    @Test
    public void WhenTariffsPageOpenClickFilterPrepaidThenAssertCountTarrifs() {
        new TariffsPage(driver).clickOnFilterPrepaid()
                .assertSelectTariffsFiltersWithDisplaysTariffs();
    }

    @Test
    public void WhenTariffsPageOpenClickFilterPostpaid() {

        new TariffsPage(driver).clickOnFilterPostpaid();
    }

    @Test
    public void WhenTariffsArchivePageOpenAssertTitle() {
        new TariffsPage(driver).clickOnTariffsArchiveLink();
        new TariffsArchivePage(driver).assertTitleTariffsArchivePage();
    }

    @Test
    public void WhenTariffsArchivePageOpenAssertURL() {
        new TariffsPage(driver).clickOnTariffsArchiveLink();
        new TariffsArchivePage(driver).assertThanTariffsArchivePage();
    }

    @Test
    public void WhenClickButton() {

        new TariffsPage(driver).checkedEnabledFilterPostpaidAndPrepaid();
    }

    @Test
    public void assertInfoTariffsWithTariffPage() {
        new  TariffsPage(driver)
                .clickInfoActiveTariffsWithTariffPage();
        new  TariffDetailPage(driver).assertTariffsInfoWithDetailPage();

    }


    @Test
    public void assertThanPayPage() {
        new TariffsPage(driver).clickButtonTopUpAccount();
        new PayPage(driver).assertPayPageWithCurrentUrl();
    }

    @Test
    public void assertClickPlugTariffClickCloseThanTarrifsPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffClose()
                .assertSelectFiltersWithTariffs();

    }

    @Test
    public void assertClickPlugTariffClickYesThanLoginPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffYes();
        new LoginPage(driver).assertLoginPageWithCurrentUrl();
    }

    @Test
    public void assertClickPlugTariffClickNoClickNoNewNumberThanMnpPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffNo()
                .clickButtonPlugTariffNoNewNumber();
        new MnpPage(driver).assertMnpPageWithCurrentUrl();
    }

    @Test
    public void assertClickPlugTariffClickNoClickNewNumberClickDeliveryThanMnpPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffNo()
                .clickButtonPlugTariffNewNumber()
                .clickButtonPlugTariffNoNewNumberDelivery();
        new ShopPage(driver).assertShopPageWithCurrentUrl();
    }

    @Test
    public void assertClickPlugTariffClickNoClickNewNumberClickFindMarketThanMnpPage() {
        new TariffsPage(driver).clickPlugTariffOnTariffPage()
                .clickButtonPlugTariffNo()
                .clickButtonPlugTariffNewNumber()
                .clickButtonPlugTariffNoNewNumberFindMarket();
        new ServiceCentersListPage(driver).assertServiceCentersListPageWithCurrentUrl();
    }

}
