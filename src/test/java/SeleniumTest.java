import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // LambdaTest Hub URL with credentials
        String username = "belalahmad";
        String accessKey = "cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj";
        String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        // Desired Capabilities for LambdaTest
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, "latest");
        capabilities.setCapability("platformName", "Windows 10"); // Change platform as needed
        capabilities.setCapability("build", "Selenium Test Build");
        capabilities.setCapability("name", "Selenium Test");
        capabilities.setCapability("user", username); // Set username explicitly
        capabilities.setCapability("accessKey", accessKey); // Set access key explicitly
        capabilities.setCapability("network", true); // Enable network logs
        capabilities.setCapability("visual", true);  // Enable visual logs
        capabilities.setCapability("video", true);   // Enable video recording
        capabilities.setCapability("console", true); // Enable console logs

        // Initiate the remote WebDriver with LambdaTest hub
        driver = new RemoteWebDriver(new URL(hubURL), capabilities);

        // Open the URL
        driver.get("https://netflix-gpt-two-livid.vercel.app/");
    }

    @Test
    public void testStep() {
        // Locate elements and perform actions
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[1]/input")).sendKeys("ayan123@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/input")).sendKeys("Ayan123@");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/button")).click();

        // Add more steps or assertions as needed
    }
}
