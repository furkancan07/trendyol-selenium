
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rf.pages.CartPage;
import org.rf.pages.HomePage;
import org.rf.pages.ProductListPage;
import org.rf.pages.ProductPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;


public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected ProductListPage listPage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        listPage = new ProductListPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterClass
    public void tearDown() {
      // driver.quit();
       //softAssert.assertAll();
    }
}