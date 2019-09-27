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

public class TestExample {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe" );
            driver = new ChromeDriver();
            baseUrl = "https://www.accuweather.com/";
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        }

        @Test
        public void testAccuweatherSearch() throws Exception {
            driver.get(baseUrl);
            Thread.sleep(3000);
            System.out.println(baseUrl);
            WebElement query = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[1]/form/input"));
            query.click();
            query.sendKeys("Durban");
            query.sendKeys(Keys.RETURN);
            WebDriverWait wait=new WebDriverWait(driver, 10);
            String currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);

            WebElement durbanlisting = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]"));
            durbanlisting.click();
            System.out.println(driver.getTitle());
            WebElement Today = driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div[3]/a[4]/span"));
            Today.click();
            Thread.sleep(3000);
            System.out.println(driver.getCurrentUrl());
            System.out.println("Current Page title is : " + driver.getTitle());

            WebElement currentdayMaxtemp = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]"));
            System.out.println("The maximum temperature for today is :" + currentdayMaxtemp.getText());
            WebElement currentdayMintemp = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]"));
            System.out.println("The  minimum temperature for today is : "+ currentdayMintemp.getText());

            WebElement nextdayMaxtemp = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]"));
            System.out.println("The maximum temperature for the next day is :" + nextdayMaxtemp.getText());
            WebElement nextdayMintemp = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]"));
            System.out.println("The maximum temperature for the next day is :" + nextdayMintemp.getText());

            WebElement next2daysMaxtemp = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]"));
            System.out.println("The maximum temperature in the next 2 days is :" + next2daysMaxtemp.getText());
            WebElement next2daysMintemp = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]"));
            System.out.println("The  minimum temperature in the next 2 days is: "+ next2daysMintemp.getText());

        }


        @After
        public void tearDown() throws Exception {
            // driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }


