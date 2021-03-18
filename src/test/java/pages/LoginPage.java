package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private static String ENDPOINT = "/auth/login";

    private static By loginSelector =  By.id("name");
    private static By passwordSelector =  By.id("password");
    private static By buttonSelector =  By.id("button_primary");
    private static By errorMessage = By.className("error-text");

    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return waits.isElementDisplayed(By.id("button_primary"));
    }

    public WebElement getLogin(){
        return waits.getElementBy(loginSelector);
    }

    public WebElement getPassword(){
        return waits.getElementBy(passwordSelector);
    }

    public WebElement getButton(){
        return driver.findElement(buttonSelector);
    }

    public String getErrorMessage (){
        return driver.findElement(errorMessage).getText();
    }



}
