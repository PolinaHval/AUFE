package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        try {
            return driver.findElement(By.id("button_primary")).isDisplayed();
        }catch (Exception exception){
            return false;
        }
    }

    public WebElement getLogin(){
        return driver.findElement(loginSelector);
    }

    public WebElement getPassword(){
        return driver.findElement(passwordSelector);
    }

    public WebElement getButton(){
        return driver.findElement(buttonSelector);
    }

    public String getErrorMessage (){
        return driver.findElement(errorMessage).getText();
    }



}
