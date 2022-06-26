import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    WebDriver driver;

    public String BASE_URL = "https://useinsider.com/";

    private static String driverName = "chrome";

    @BeforeAll
    public void setUp() {
        switch (driverName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            }
        }

        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
