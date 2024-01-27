
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class testNGAutomationAnywhereTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the updated ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testProcessDiscoveryNavigation() {
        try {
            // Navigate to the website
            driver.get("https://www.automationanywhere.com/");

            // Create an Actions object for mouse-over
            Actions actions = new Actions(driver);

            // a. Do Mouse over on Products
            WebElement productsMenu = driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[2]/a"));
            actions.moveToElement(productsMenu).perform();

            System.out.println("Mouse-over on Products menu");

            // b. Click on Process Discovery after waiting for it to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement processDiscoveryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[2]/div/div/div/div/div[3]/ul/li[1]/ul/li/a")));
            processDiscoveryLink.click();
            Thread.sleep(2000);

            System.out.println("Clicked on Process Discovery link");

            // c. Verify that it's navigating to the correct URL
            String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl, "Navigation URL is not as expected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
