package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteProjectPage extends BasePage {

    private static String ENDPOINT="/admin/projects/overview";

    protected By deleteSelector= By.xpath("//a[text()=\"Polina\"]/ancestor::tr[@class=\"odd hoverSensitive\"]" +
            "/descendant::div[@class=\"icon-small-delete\"]");
    protected By checkboxSelector = By.xpath("//span[@class=\"dialog-confirm-busy\"]/../input[@type=\"checkbox\" ]");
    protected By okButtonSelector =By.xpath("//*[@class='icon-progress-inline']/following::a[1]");

    public DeleteProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return waits.isElementDisplayed(By.id("navigation-sub-users"));
    }


    public WebElement getDeleteButton(){
        return waits.getElementBy(deleteSelector);
    }


    public WebElement getCheckbox(){
        return waits.getElementBy(checkboxSelector);
    }

    public WebElement getOk(){
        return waits.getElementBy(okButtonSelector);
    }

}
