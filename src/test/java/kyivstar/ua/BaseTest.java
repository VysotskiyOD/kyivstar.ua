package kyivstar.ua;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;


    @Before
    public void setUp() {
        URL host = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        try {
            host = new URL("http://localhost:4445/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(host, capabilities);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://beta.kyivstar.ua/tariffs");
    }

    @After
    public void out() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.quit();
    }

}

