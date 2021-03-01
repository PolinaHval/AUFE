package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProject extends BasePage {

    private static String ENDPOINT = "/admin/projects/overview";

    private static By editButtonSelector=By.linkText("First");
    private static By nameSelector = By.id("name");
    private static By addButtonSelector = By.id("accept");


    public EditProject(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return driver.findElement(By.id("navigation-sub-overview")).isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    public WebElement getEditButton(){
        return driver.findElement(editButtonSelector);
    }

    public WebElement getNameProject (){
        return driver.findElement(nameSelector);
    }

    public WebElement getAddButton (){
        return driver.findElement(addButtonSelector);
    }
}
