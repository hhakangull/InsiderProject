import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualityAssurancePage extends BasePage{
    WebDriverWait driverWait = new WebDriverWait(this.driver,10);

    By btnSeeAllQaJobs = By.linkText("See all QA jobs");

    public String qa_page_link = "https://useinsider.com/careers/quality-assurance/";

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }


    public void clickSeeAllJobs() {
        clickElement(btnSeeAllQaJobs);
    }
}
