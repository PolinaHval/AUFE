package wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.Waits;

import java.util.List;

public class UIElement implements WebElement {

    private WebDriver driver;
    private By by = null;
    private WebElement webElement;
    private Waits waits;
    private JavascriptExecutor jsExecutor;

    public UIElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        this.waits = new Waits(driver);
        this.jsExecutor = (JavascriptExecutor) driver;

        this.webElement = waits.getElementBy(by);
    }

    public UIElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;
        this.waits = new Waits(driver);
        this.jsExecutor = (JavascriptExecutor) driver;

    }

    @Override
    public void click() {
        try {
            webElement.click();
        }catch (ElementNotInteractableException enie){
            jsExecutor.executeScript("arguments[0].scrollIntoView(true)",webElement);
            waits.isElementClickable(webElement);
            webElement.click();
        }

    }

    @Override
    public void submit() {
        webElement.submit();

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement.sendKeys();

    }

    @Override
    public void clear() {
        webElement.clear();

    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement. isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public UIElement findElement(By by) {
        return new UIElement(driver,webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }
}
