import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {




    By btnHomeLogin = By.xpath("//a[text()='Login']");
    By btnHomeMoreMenu = By.linkText("More");
    By bodyMoreContent = By.xpath("//div[@aria-labelledby='mega-menu-1' and @class='dropdown-menu show']");
    By popUp = By.xpath("//div[contains(@id,'close-button') and @class='element-content']");
    By txtCareers = By.xpath("//div[@class='dropdown-menu show']//h5[text()='Careers']");

    By cookies = By.id("wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean checkContentArea(){
        return isDisplayed(bodyMoreContent);
    }

    public void clickCareers(){
        clickElement(txtCareers);
    }

    public void clickContentMoreBtn(){
        clickElement(btnHomeMoreMenu);
    }

    public void clickCookies(){
        clickElement(cookies);
    }


    public  boolean checkHomePageIsDisplayed(){
        return isDisplayed(btnHomeLogin);
    }

}
