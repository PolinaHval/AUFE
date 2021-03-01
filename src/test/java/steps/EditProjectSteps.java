package steps;

import org.openqa.selenium.WebDriver;
import pages.EditProject;

public class EditProjectSteps {
     private WebDriver driver;

    public EditProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void editProject(String username, String psw, String newName){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username,psw);
        EditProject editProject = new EditProject(driver, true);
        editProject.getEditButton().click();
        editProject.getNameProject().clear();
        editProject.getNameProject().sendKeys(newName);
        editProject.getAddButton().submit();
    }
}
