package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CreateProject;

public class CreateProjectSteps {

    private WebDriver driver;

    public CreateProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void create (String username, String psw, String nameProject){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
        CreateProject createProject = new CreateProject(driver,true);
        createProject.getNameProject().sendKeys(nameProject);
        createProject.getAddButton().submit();
    }
}
