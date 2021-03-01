package steps;

import org.openqa.selenium.WebDriver;
import pages.DeleteProjectPage;

public class DeleteProjectSteps {
    private WebDriver driver;

    public DeleteProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteProject(String userName,String psw){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(userName,psw);
        DeleteProjectPage deleteProjectPage = new DeleteProjectPage(driver,true);
        deleteProjectPage.getDeleteButton().click();
        deleteProjectPage.getCheckbox().click();
        deleteProjectPage.getOk().click();
    }
}
