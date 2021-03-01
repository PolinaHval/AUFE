package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.CreateProjectSteps;
import steps.DeleteProjectSteps;
import steps.EditProjectSteps;
import steps.LoginSteps;

public class MainTest extends BaseTest {

    @Test(priority = 1)
    public void loginPositiveTest(){

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void loginNegativeTest1(){

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver,false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.","Incorrect message");
    }

    @Test(priority = 3)
    public void loginNegativeTest2(){

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), "fail");

        Assert.assertEquals(new LoginPage(driver,false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.","Incorrect message");
    }

    @Test(priority = 4)
    public void loginNegativeTest3(){

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", "fail");

        Assert.assertEquals(new LoginPage(driver,false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.","Incorrect message");
    }


    @Test(priority = 5)
    public void createProjectTest(){
        CreateProjectSteps createProjectSteps = new CreateProjectSteps(driver);
        createProjectSteps.create(readProperties.getUserName(), readProperties.getPassword(),
                readProperties.getNameProject());

        Assert.assertTrue(true);
    }

    @Test(priority = 6)
    public void editProjectTest(){
        EditProjectSteps editProjectSteps = new EditProjectSteps(driver);
        editProjectSteps.editProject(readProperties.getUserName(), readProperties.getPassword(),
                readProperties.getNewName());
        Assert.assertTrue(true);
    }

    @Test(priority = 7)
    public void deleteProjectTest(){
        DeleteProjectSteps deleteProjectSteps = new DeleteProjectSteps(driver);
        deleteProjectSteps.deleteProject(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @DataProvider(name = "набор кредов")
    public Object [][] credentialsForTest (){
        return new Object[][] {
                {"liza.khval@mail.ru","Polina1234"},
                {"incorrectUserName","Polina1234"},
                {"liza.khval@mail.ru","incorrectPasword"},
        };
    }

    @Test (enabled = false,dataProvider="набор кредов")
    public void testLoginWithMultipleCredentials( String username, String psw){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
    }

    @Parameters({"username","psw"})
    @Test(enabled = false)
    public void testLoginWithParameters(@Optional("1") String username, @Optional("2") String psw){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
    }
}
