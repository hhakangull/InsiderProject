import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Insider_End_to_End extends BaseTest {
    HomePage homePage;
    CareerPage careerPage;
    QualityAssurancePage qualityAssurancePage;
    DepartmentPage departmentPage;
    JobDetailsPage jobDetailsPage;


    @Test
    @Order(1)
    public void checkInsiderHomepage() {
        homePage = new HomePage(driver);
        boolean result = homePage.checkHomePageIsDisplayed();
        Assertions.assertTrue(result, "Anasayfa dogrulanamadi.");
    }

    @Test
    @Order(2)
    public void clickMoreContentBtn() {
        homePage.clickCookies();
        homePage.clickContentMoreBtn();
    }

    @Test
    @Order(3)
    public void clickCheckContentAreaAndClickCareers() {
        Assertions.assertTrue(homePage.checkContentArea(), "Content acilamadi");
        homePage.clickCareers();
    }

    @Test
    @Order(4)
    public void clickSeeAllTeamsOnCareerPage() {
        careerPage = new CareerPage(driver);
        String x = driver.getCurrentUrl();
        Assertions.assertEquals(careerPage.careerPage, driver.getCurrentUrl());
    }

    @Test
    @Order(5)
    public void clickSeeAllTeams() throws InterruptedException {
        careerPage.clickSeeAllTeams();
    }

    @Test
    @Order(6)
    public void clickQaBtn() {
        careerPage.clickBtnQualityAssurance();
    }

    @Test
    @Order(7)
    public void checkQaPage() {
        qualityAssurancePage = new QualityAssurancePage(driver);
        String x = driver.getCurrentUrl();
        Assertions.assertEquals(qualityAssurancePage.qa_page_link, driver.getCurrentUrl());
    }

    @Test
    @Order(8)
    public void clickSeeAllQaJobs()  {
        qualityAssurancePage.clickSeeAllJobs();
    }

    @Test
    @Order(9)
    public void clickSelectionArea(){
        departmentPage = new DepartmentPage(driver);
        Assertions.assertEquals(departmentPage.departmentLink, driver.getCurrentUrl());
        departmentPage.clickSelectionArea();
    }
    @Test
    @Order(10)
    public void selectTurkeyLocation(){
        departmentPage.selectTurkeyLocation();
    }

    @Test
    @Order(11)
    public void checkJobs(){
        Assertions.assertTrue(departmentPage.isDisplayedJobs());

    }

    @Test
    @Order(11)
    public void clickApplyButton() throws InterruptedException {
        Assertions.assertTrue(departmentPage.clickApplyButton());
    }

    @Test
    @Order(12)
    public void changeWindowTab(){
        departmentPage.changeWindowTab();
    }

    @Test
    @Order(13)
    public void checkNewWindow() throws InterruptedException {
        jobDetailsPage = new JobDetailsPage(driver);
        Assertions.assertTrue(jobDetailsPage.checkLink());
        Thread.sleep(4000);
    }
}
