import domain.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object.*;

public class BaseTest {

    public static final String PATH_CHROME = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
    public static final String PATH_YANDEX = "\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
    protected WebDriver driver;
    protected MainPage mainPage;
    protected User user;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected RestorePage restorePage;
    protected AccountPage accountPage;

    @Before
    public void setUp() {
        String chromeBrowserPath = PATH_CHROME;
//        String yandexBrowserPath = System.getenv("USERPROFILE") + PATH_YANDEX;
        ChromeOptions options = new ChromeOptions();
//        options.setBinary(yandexBrowserPath);
        options.setBinary(chromeBrowserPath);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePage = new RestorePage(driver);
        accountPage = new AccountPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}