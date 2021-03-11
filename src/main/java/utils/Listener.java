package utils;

import baseEntities.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

import org.testng.ITestResult;



public class Listener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Тест выполнился успешно");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Тест упал");

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;
        byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
