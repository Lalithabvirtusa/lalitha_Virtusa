import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AutomationAnywhereTest {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://www.automationanywhere.com/");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Create an Actions object for mouse-over
            Actions actions = new Actions(driver);

            // a. Do Mouse over on Products
            WebElement productsMenu = driver.findElement(By.xpath("//a[text()='Products']"));
            actions.moveToElement(productsMenu).perform();

            // b. Click on Process Discovery
            WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[text()='Process Discovery']"));
            processDiscoveryLink.click();

            // c. Verify that it's navigating to the correct URL
            String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Navigation successful. URL is as expected.");
            } else {
                System.out.println("Navigation failed. URL is not as expected.");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
