import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SeleniumTest {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        // LambdaTest Hub URL with credentials
        String username = "belalahmad";
        String accessKey = "cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj";
        String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("127");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "belalahmad");
        ltOptions.put("accessKey", "cousQqH3syuMR3H55LiQfG4QqCyPHRsZs3XJ3mbEle94hOdYLj");
        ltOptions.put("project", "BelalWebTest");
        ltOptions.put("build","Belal Web Automation Test");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        // Initiate the remote WebDriver with LambdaTest hub
        driver = new RemoteWebDriver(new URL(hubURL), browserOptions);

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
    @AfterTest
    public void tearDown() {
        // Close the browser and end the session
        if (driver != null) {
            driver.quit();
        }
    }
}
