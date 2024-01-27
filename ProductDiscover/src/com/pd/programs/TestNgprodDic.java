package com.pd.programs;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgprodDic {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testNavigationToProcessDiscovery() {
        try {
            System.out.println("Navigating to the website...");
            driver.get("https://www.automationanywhere.com");
            Actions actions = new Actions(driver);
            WebElement productsMenu = driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[2]/a"));
            System.out.println("Performing mouse-over on Products...");
            actions.moveToElement(productsMenu).perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            WebElement processDiscoveryLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[2]/ul/li[2]/div/div/div/div/div[3]/ul/li[1]/ul/li/a")));
            System.out.println("Clicking on Process Discovery link...");
            processDiscoveryLink.click();
            String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
            System.out.println("Waiting for URL to be " + expectedUrl);
            wait.until(ExpectedConditions.urlToBe(expectedUrl));
            String actualUrl = driver.getCurrentUrl();
            System.out.println("Actual URL: " + actualUrl);
            Assert.assertEquals(actualUrl, expectedUrl, "Navigation failed. URL is not as expected.");
            System.out.println("Navigation successful. URL is as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing the browser...");
            driver.quit();
        }
    }
}
