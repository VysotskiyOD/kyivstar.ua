package ua.kyivstar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;


public class TariffsPage {

    private WebDriver driver;
    private final String titlePage = "Тарифи";
    private final String okCheckboxPrepaid = "prepaid";
    private final String okCheckboxPostpaid = "postpaid";
    private final String xPathCheckboxPostpaid = "//label[@for='postpaid']";
    private final String xPathCheckboxPrepaid = "//label[@for='prepaid']";
    private final String xPathCheckPassport = "//p[@class='TariffItem_tariff-item__passport__N_-22']";
    private final String tariffsArchiveLink = "//a[@class='TariffsArchive_tariffs-archive__link__3xDNR']";
    private final String infoTariffs = "//a[@class='link link--m link--decoration-none TariffItem_tariff-item__more__3DGRT']";
    private final String infoActiveTariffs = "//div[contains(@class,'slick-slide slick-active')]";
    private final String buttonTopUpAccount = "//span[contains(text(), 'Поповнити рахунок')]";
    private final String buttonLinkGoogle = "//a[@aria-label='google-store-link']";
    private final String buttonLinkApple = "//a[@aria-label='app-store-link']";
    private final String buttonPlugTariff = "//span[contains(text(), 'Підключити')]";
    private final String buttonPlugTariffYes = "//span[contains(text(), 'Так')]";
    private final String buttonPlugTariffNo = "//span[contains(text(), 'Ні')]";
    private final String buttonPlugTariffClose = "//button[@class='btn btn--quiet btn--s btn--icon modal__close']";
    private final String buttonPlugTariffNoNewNumber = "//span[contains(text(), 'Хочу зберегти номер')]";
    private final String buttonPlugTariffNewNumber = "//span[contains(text(), 'Хочу новий номер')]";
    private final String buttonPlugTariffNoNewNumberFindMarket = "//span[contains(text(), 'Знайти магазин')]";
    private final String buttonPlugTariffNoNewNumberDelivery = "//span[contains(text(), 'Замовити доставку')]";


    public TariffsPage(WebDriver driver) {
        this.driver = driver;
    }



    public TariffsPage assertThanTariffsPage() {
        Assert.assertTrue(driver.getCurrentUrl()
                .startsWith("http://beta.kyivstar.ua/tariffs"));
        return this;
    }

    public TariffsPage assertTitleTariffsPage() {
        Assert.assertTrue(driver.getTitle().contentEquals(titlePage));
        return this;
    }

    public TariffsPage clickButtonTopUpAccount() {
        driver.findElement(By.xpath(buttonTopUpAccount)).click();
        return this;
    }

 /*   public TariffsPage clickButtonLinkGoogle() {
        driver.findElement(By.xpath(buttonLinkGoogle)).click();
        return this;
    }

    public TariffsPage clickButtonLinkApple() {
        driver.findElement(By.xpath(buttonLinkApple)).click();
        return this;
    }
*/
    public TariffsPage assertSelectFiltersWithTariffs() {
        List<WebElement> findElementsTabs = driver.findElements(By.xpath(xPathCheckPassport));
            if(driver.findElement(By.id(okCheckboxPostpaid)).isEnabled()
                & driver.findElement(By.id(okCheckboxPrepaid)).isEnabled())
            {
                for(int i = 0; i<findElementsTabs.size(); i++){
                    if (findElementsTabs.get(i).getText().contains("паспорт"))
                    Assert.assertTrue(findElementsTabs.get(i).getText().startsWith("Підключаємо"));
                }
            }

        if(!driver.findElement(By.id(okCheckboxPostpaid)).isEnabled()
                & driver.findElement(By.id(okCheckboxPrepaid)).isEnabled())
        {
            for(int i = 0; i<findElementsTabs.size(); i++){
                if (findElementsTabs.get(i).getText().contains("паспорт"))
                    Assert.assertTrue(findElementsTabs.get(i).getText().startsWith("Підключаємо без паспорта"));
            }
        }

        if(driver.findElement(By.id(okCheckboxPostpaid)).isEnabled()
                & !driver.findElement(By.id(okCheckboxPrepaid)).isEnabled())
        {
            for(int i = 0; i<findElementsTabs.size(); i++){
                if (findElementsTabs.get(i).getText().contains("паспорт"))
                    Assert.assertTrue(findElementsTabs.get(i).getText().startsWith("Підключаємо з паспортом"));
            }

        }

        return this;
    }

    public TariffsPage assertSelectTariffsFiltersWithDisplaysTariffs() {
        List<WebElement> findElementsTariffs = driver.findElements(By.xpath(xPathCheckPassport));
        List<String> distinctNeedHavePassport = new ArrayList<>();

        if(driver.findElement(By.id(okCheckboxPostpaid)).isEnabled()
                & driver.findElement(By.id(okCheckboxPrepaid)).isEnabled())
        {

            for (WebElement element : findElementsTariffs) {
                if (!distinctNeedHavePassport.contains(element.getText())
                        & (element.getText().contains("паспорт")))
                    distinctNeedHavePassport.add(element.getText());

            }
            Assert.assertTrue(distinctNeedHavePassport.size()>1);

        }

        if(!driver.findElement(By.id(okCheckboxPostpaid)).isEnabled()
                & driver.findElement(By.id(okCheckboxPrepaid)).isEnabled())
        {
            for (WebElement element : findElementsTariffs) {
                if (!distinctNeedHavePassport.contains(element.getText())
                        & (element.getText().contains("паспорт")))
                    distinctNeedHavePassport.add(element.getText());

            }
            Assert.assertTrue(distinctNeedHavePassport.size()==1);
        }

        if(driver.findElement(By.id(okCheckboxPostpaid)).isEnabled()
                & !driver.findElement(By.id(okCheckboxPrepaid)).isEnabled())
        {
            for (WebElement element : findElementsTariffs) {
                if (!distinctNeedHavePassport.contains(element.getText())
                        & (element.getText().contains("паспорт")))
                    distinctNeedHavePassport.add(element.getText());

            }
            Assert.assertTrue(distinctNeedHavePassport.size()==1);
        }

        return this;
    }


    public TariffsPage clickInfoActiveTariffsWithTariffPage() {

        Random rand = new Random();
        List<WebElement> findElementsTariffsInfoHref = driver.findElements(By.xpath(infoTariffs));
        List<WebElement> findElementsClickActiveTariffs = driver.findElements(By.xpath(infoActiveTariffs));
        int countClickActiveTariffs=findElementsClickActiveTariffs.size();
        System.out.println(countClickActiveTariffs);

        int randomIndex = rand.nextInt(countClickActiveTariffs);
                String URLTarrif = findElementsTariffsInfoHref.get(randomIndex).getAttribute("href")
                        .replaceAll("/tariffs","");
                findElementsTariffsInfoHref.get(randomIndex).click();
        return this;
    }


    public TariffsPage clickPlugTariffOnTariffPage() {

        Random rand = new Random();

        List<WebElement> findElementsTariffsPlug = driver.findElements(By.xpath(buttonPlugTariff));
        List<WebElement> findElementsClickActiveTariffsPlug = driver.findElements(By.xpath(infoActiveTariffs));
        List<Integer> distinctElementsClickActiveTariffsPlug = new ArrayList<>();

        for(int i = 0; i<findElementsClickActiveTariffsPlug.size(); i++){
            if (findElementsClickActiveTariffsPlug.get(i).getText().contains("Підключити"))
                distinctElementsClickActiveTariffsPlug.add(i);
        }
        int randomIndex = rand.nextInt(distinctElementsClickActiveTariffsPlug.size());

        findElementsTariffsPlug.get(randomIndex).click();
        return this;
    }

    public TariffsPage clickButtonPlugTariffYes() {
        driver.findElement(By.xpath(buttonPlugTariffYes)).click();
        return this;
    }

    public TariffsPage clickButtonPlugTariffNo() {
        driver.findElement(By.xpath(buttonPlugTariffNo)).click();
        return this;
    }

    public TariffsPage clickButtonPlugTariffClose() {
        driver.findElement(By.xpath(buttonPlugTariffClose)).click();
        return this;
    }

    public TariffsPage clickButtonPlugTariffNoNewNumber() {
        driver.findElement(By.xpath(buttonPlugTariffNoNewNumber)).click();
        return this;
    }

    public TariffsPage clickButtonPlugTariffNewNumber() {
        driver.findElement(By.xpath(buttonPlugTariffNewNumber)).click();
        return this;
    }

    public TariffsPage clickButtonPlugTariffNoNewNumberFindMarket() {
        driver.findElement(By.xpath(buttonPlugTariffNoNewNumberFindMarket)).click();
        return this;
    }

    public TariffsPage clickButtonPlugTariffNoNewNumberDelivery() {
        driver.findElement(By.xpath(buttonPlugTariffNoNewNumberDelivery)).click();
        return this;
    }

    public TariffsPage checkedEnabledFilterPrepaidAndDisablePostpaid() {
        Assert.assertFalse(driver.findElement(By.id(okCheckboxPostpaid)).isEnabled());
        return this;
    }

    public TariffsPage checkedEnabledFilterPostpaidAndDisablePrepaid() {
        Assert.assertFalse(driver.findElement(By.id(okCheckboxPrepaid)).isEnabled());
        return this;
    }

    public TariffsPage checkedEnabledFilterPostpaidAndPrepaid() {
        Assert.assertTrue(driver.findElement(By.id(okCheckboxPrepaid)).isEnabled());
        Assert.assertTrue(driver.findElement(By.id(okCheckboxPostpaid)).isEnabled());
        return this;
    }

    public TariffsPage clickOnFilterPrepaid() {
        if ( driver.findElement(By.id(okCheckboxPrepaid)).isSelected() )
        {
            driver.findElement(By.xpath(xPathCheckboxPrepaid)).click();
        }
        return this;
    }

    public TariffsPage clickOnFilterPostpaid() {
        if ( driver.findElement(By.id(okCheckboxPostpaid)).isSelected() )
        {
            driver.findElement(By.xpath(xPathCheckboxPostpaid)).click();
        }
        return this;
    }

    public TariffsPage clickOnTariffsArchiveLink() {
            driver.findElement(By.xpath(tariffsArchiveLink)).click();
        return this;
    }


}
