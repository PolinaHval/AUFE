package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.UIElement;

public class UIElementsTests extends BaseTest {

    @Test
    public void initTest(){
        LoginPage loginPage = new LoginPage(driver,true);
        UIElement element = loginPage.getLogin();
        element.click();
    }
}
