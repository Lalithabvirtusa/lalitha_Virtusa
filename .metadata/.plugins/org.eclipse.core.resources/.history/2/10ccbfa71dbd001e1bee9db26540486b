
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationAnywhereTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.automationanywhere.com/");
            driver.manage().window().maximize();
            Actions actions = new Actions(driver);
            WebElement productsMenu = driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[2]/a"));
            actions.moveToElement(productsMenu).perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement processDiscoveryLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[2]/div/div/div/div/div[3]/ul/li[1]/ul/li/a")));
            processDiscoveryLink.click();
            Thread.sleep(2000);
            String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Navigation successful. URL is as expected.");
            } else {
                System.out.println("Navigation failed. URL is not as expected.");
            }
        } finally {
            driver.quit();
        }
    }
}


