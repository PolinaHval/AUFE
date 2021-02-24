package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();

    public BaseTest() {
    }

    @BeforeMethod
    public void setUp(){
        this.driver = new BrowserService().getDriver();
        driver.get(new ReadProperties().getURL()); // сделать логин страницу на тест рейле, прописать методы, ие

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
