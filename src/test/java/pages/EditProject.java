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
      return waits.isElementDisplayed(By.id("navigation-sub-overview"));

    }

    public WebElement getEditButton(){
        return waits.getElementBy(editButtonSelector);
    }

    public WebElement getNameProject (){
        return waits.getElementBy(nameSelector);
    }

    public WebElement getAddButton (){
        return waits.getClickableButton(addButtonSelector);
    }
}
