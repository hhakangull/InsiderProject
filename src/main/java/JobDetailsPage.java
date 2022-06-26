import org.openqa.selenium.WebDriver;

public class JobDetailsPage extends BasePage{

    public String checkLink = "https://jobs.lever.co/";

    public JobDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkLink(){
        return driver.getCurrentUrl().contains(checkLink);
    }
}
