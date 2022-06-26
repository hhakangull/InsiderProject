import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerPage extends BasePage{

    By btnSeeAllTeams = By.xpath("//div[@class='container']//a[text()='See all teams']");
    By btnQa = By.xpath("//a[contains(@href,'quality-assurance')]//h3");
    public String careerPage = "https://useinsider.com/careers/";

    WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

    public CareerPage(WebDriver driver) {
        super(driver);

    }


    public void clickSeeAllTeams() {
        goToElement(btnSeeAllTeams);
        clickElement(btnSeeAllTeams);
    }

    public void clickBtnQualityAssurance(){
        clickElement(btnQa);
    }
}
