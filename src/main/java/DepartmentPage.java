import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DepartmentPage extends BasePage {

    By selectionArea = By.id("select2-filter-by-location-container");
    By liTurkey = By.xpath("//li[contains(@id,'select2-filter-by-location-result') and contains(@id,'Istanbul, Turkey')]");
    By jobList = By.id("jobs-list");
    By locationList = By.xpath("//div[@id='jobs-list']//div[@class='position-location text-large']");
    By jobContent = By.xpath("//div[@id='jobs-list']//div[@class='position-list-item-wrapper bg-light']");
    By btnApplyNow = By.xpath("//div[@id='jobs-list']//div[@class='position-list-item-wrapper bg-light']//a");


    public int selectedValue = 0;
    public String departmentLink = "https://useinsider.com/careers/open-positions/?department=qualityassurance";

    public DepartmentPage(WebDriver driver) {
        super(driver);
    }

    public void clickSelectionArea() {
        clickElement(selectionArea);
    }

    public void selectTurkeyLocation() {
        clickElement(liTurkey);
    }

    public boolean isDisplayedJobs() {
        return isDisplayed(jobList);
    }

    public int getRandomValue() {
        int max = count(jobContent);
        return (int) (Math.random() * (max - 1) + 1);
    }

    public boolean clickApplyButton() throws InterruptedException {
        selectedValue= getRandomValue();
        Thread.sleep(1500);
        List<WebElement> webElements = findAll(btnApplyNow);
        List<WebElement> webElementListLocation = findAll(locationList);
        if(webElementListLocation.get(selectedValue).getText().contains("Istanbul")){
            clickElementWithElement(webElements.get(selectedValue));
            return true;
        } else {
            return false;
        }

    }


    public void changeWindowTab() {
        String currentWindow = driver.getWindowHandle();
        var x = driver.getWindowHandles();
        for (String window : driver.getWindowHandles()) {
            System.out.println(currentWindow);
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
    }

}
