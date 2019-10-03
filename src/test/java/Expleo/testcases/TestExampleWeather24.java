package Expleo.testcases;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import Expleo.pageobjects.Weather24;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
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
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://weather.news24.com/";
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
    }

    @Test
    public void testWeather24search() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println("Current Page URL is : " + driver.getCurrentUrl());
        //Thread.sleep(2000);
        Weather24 citySearch = PageFactory.initElements(driver, Weather24.class);
        citySearch.setSearch();
        citySearch.setCity();
        citySearch.submitSearch();
        Thread.sleep(2000);
        citySearch.selectDay();
        Thread.sleep(2000);

        String[] max24 = new String[5];
        String[] min24 = new String[5];

        max24[0] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[4]")).getText();
        min24[0] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[3]/td[5]")).getText();

        max24[1] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]")).getText();
        min24[1] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]")).getText();

        max24[2] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]")).getText();
        min24[2] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]")).getText();

        max24[3] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]")).getText();
        min24[3] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]")).getText();

        max24[4] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]")).getText();
        min24[4] = driver.findElement(By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]")).getText();


        for (int i = 0; i < 5; i++) {
            System.out.println("Weather day" + (i + 1) + ": Maximum Temperature: " + max24[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Weather Day" + (i + 1) + ": Minimum Temperature:" + min24[i]);
        }
    }}