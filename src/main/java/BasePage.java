import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait driverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(this.driver, 15);
    }


    public void clickElement(By locator){
        WebElement element = driverWait.until(ExpectedConditions.elementToBeClickable(locator));
        goToElement(locator);
        element.click();

    }
    public void clickElementWithElement(WebElement element){
        goToElement(element);
        driverWait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }



    public int count(By locator){
        List<WebElement> webElement = findAll(locator);
        return webElement.size();
    }

    public void moveToElement(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(find(locator));
    }



    public void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void goToElement(By locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(find(locator));
        actions.perform();
    }
    public void goToElement(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();
    }
}
