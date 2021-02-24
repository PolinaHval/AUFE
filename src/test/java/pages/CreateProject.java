package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProject extends BasePage {

    private static String ENDPOINT = "/admin/projects/add/1";

    private static By nameSelector = By.id("name");
    private static By addButtonSelector = By.id("accept");


    public CreateProject(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage(){
        driver.get(BASE_URL+ENDPOINT);

    }

    @Override
    public boolean isPageOpened() {
        try {
            return driver.findElement(By.id("accept")).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public WebElement getNameProject (){
        return driver.findElement(nameSelector);
    }

    public WebElement getAddButton (){
        return driver.findElement(addButtonSelector);
    }

}
