package browserService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class BrowserService {
    private WebDriver driver = null;

    public BrowserService() {
        String browserName = new ReadProperties().getBrowserName();

        switch(browserName.toLowerCase()) {
            case "chrome":
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
                String absolutePath = file.getAbsolutePath();

                System.setProperty("webdriver.chrome.driver",absolutePath);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(new ReadProperties().isHeadless());

                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "ie":
               classLoader = getClass().getClassLoader();
               file = new File(classLoader.getResource("drivers/IEDriverServer.exe").getFile());

               absolutePath = file.getAbsolutePath();

                System.setProperty("webdriver.ie.driver",absolutePath);

                driver = new InternetExplorerDriver();

                break;
            default:
                System.out.println("Browser is not supported");
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
