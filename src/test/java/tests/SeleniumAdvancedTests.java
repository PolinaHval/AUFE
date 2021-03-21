package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumAdvancedTests extends BaseTest {

    @Test
    public void alertTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement field = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(field).build().perform();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }


    @Test
    public void uploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement getFile = driver.findElement(By.id("file-upload"));

        getFile.sendKeys("C:\\Users\\Comp\\Desktop\\Polina.jpg");

        WebElement button = driver.findElement(By.id("file-submit"));
        button.submit();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "Polina.jpg",
                "filename does not match");
    }

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/frames");

        WebElement iframe = driver.findElement(By.linkText("iFrame"));
        iframe.click();

        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");
        driver.switchTo().parentFrame();
    }

    @Test
    public void DynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        WebElement removeButton = driver.findElement(By.cssSelector("[onclick=\"swapCheckbox()\"]"));

        checkbox.click();
        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver,15);
        webDriverWait.until(ExpectedConditions.textToBe(By.id("message"),"It's gone!"));


        WebElement input = driver.findElement(By.cssSelector("[type=\"text\"]"));
        Assert.assertTrue(input.isDisplayed());

        WebElement enableButton = driver.findElement(By.cssSelector("[onclick=\"swapInput()\"]"));
        enableButton.click();

        webDriverWait.until(ExpectedConditions.textToBe(By.linkText("It's enabled!"),"It's enabled!"));
        Assert.assertTrue(input.isEnabled());
    }
}
