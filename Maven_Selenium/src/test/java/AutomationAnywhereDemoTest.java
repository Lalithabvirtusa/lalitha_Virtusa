
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AutomationAnywhereDemoTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.automationanywhere.com/");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            acceptCookies(driver, wait);
            By requestDemoButton = By.xpath("//a[@title='Request demo']");
            WebElement requestDemoElement = wait.until(ExpectedConditions.elementToBeClickable(requestDemoButton));
            System.out.println("Before clicking Request Demo button");
            Thread.sleep(2000);
            try {
                requestDemoElement.click();
                System.out.println("After clicking Request Demo button");
            } catch (Exception e) {
                System.out.println("Exception while clicking Request Demo button: " + e.getMessage());
            }           
            wait.until(ExpectedConditions.urlToBe("https://www.automationanywhere.com/request-live-demo"));

            By firstNameLabel = By.xpath("//*[@id=\"LblFirstName\"]");
            By lastNameLabel = By.xpath("//*[@id=\"LblLastName\"]");

            WebElement firstNameLabelElement = driver.findElement(firstNameLabel);
            WebElement lastNameLabelElement = driver.findElement(lastNameLabel);

            System.out.println("First Name Label: " + firstNameLabelElement.getText());
            System.out.println("Last Name Label: " + lastNameLabelElement.getText());

        } finally {
            driver.quit();
        }
    }
    
    private static void acceptCookies(WebDriver driver, WebDriverWait wait) {
    	    try {
            By acceptCookiesButton = By.xpath("//button[contains(text(),'Accept All Cookies')]");
            WebElement acceptCookiesElement = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));

            if (acceptCookiesElement.isDisplayed()) {
                acceptCookiesElement.click();
            }
        } catch (Exception e) {
             System.out.println("Exception while accepting cookies: " + e.getMessage());
        }
    }
}
