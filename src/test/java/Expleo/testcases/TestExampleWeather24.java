package Expleo.testcases;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExampleWeather24 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe" );
        driver = new ChromeDriver();
        baseUrl = "http://weather.news24.com/";
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

           }


    @Test
    public void testWeather24search() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        WebElement citybutton = driver.findElement(By.xpath("//*[@id='ctl00_WeatherContentHolder_ddlCity']"));
        citybutton.click();
        WebElement citySelect = driver.findElement(By.xpath("//*[@id='ctl00_WeatherContentHolder_ddlCity']/option[19]"));
        citySelect.click();
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement gobutton = driver.findElement(By.xpath("//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]"));
        gobutton.click();
        Thread.sleep(3000);
        System.out.println("Current Page URL is : " + driver.getCurrentUrl());
        System.out.println("City name is " + driver.findElement(By.xpath("//*[@id=\"cityInfo\"]/h1")).getText());
    }
}