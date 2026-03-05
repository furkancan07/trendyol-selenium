
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rf.pages.HomePage;
import org.rf.pages.ProductListPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;


public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected ProductListPage listPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        listPage = new ProductListPage(driver);
    }

    @AfterClass
    public void tearDown() {
      // driver.quit();
      // softAssert.assertAll();
    }
}