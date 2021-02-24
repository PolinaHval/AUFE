package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;

public class MainTest extends BaseTest {

    @Test
    public void loginPositiveTest(){

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test
    public void loginNegativeTest(){

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver,false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.","Incorrect message");
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
    @Test
    public void testLoginWithParameters(@Optional("1") String username, @Optional("2") String psw){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
    }
}
