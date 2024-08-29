import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleniumTest {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // You can add more test logic here
        driver=new ChromeDriver();
        driver.get("https://netflix-gpt-two-livid.vercel.app/");
    }

    @Test
    void testStep()
    {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[1]/input")).sendKeys("ayan123@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/input")).sendKeys("Ayan123@");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/button")).click();

//        WebElement webElement=driver.findElement(By.xpath())
    }
}
