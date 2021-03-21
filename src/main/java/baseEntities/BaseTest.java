package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Listener;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class BaseTest {

    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();

    public BaseTest() {
    }

    @BeforeMethod
    public void setUp(){
        this.driver = new BrowserService().getDriver();
        driver.get(new ReadProperties().getURL());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
