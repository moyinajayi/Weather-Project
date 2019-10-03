package Expleo.testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import Expleo.pageobjects.Accuweather;
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
            driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        }


        @Test
        public void testAccuweatherSearch() throws Exception {
            driver.get(baseUrl);
            //    WebDriverWait wait=new WebDriverWait(driver, 10);
            System.out.println("Current Page title is : " + driver.getTitle());
            Accuweather citySearch = PageFactory.initElements(driver, Accuweather.class);

            citySearch.setSearch("durban");
            Thread.sleep(2000);
            citySearch.selectDay();
            Thread.sleep(2000);
            citySearch.specifyDay();
            Thread.sleep(2000);


            String[] maxAccu = new String[5];
            String[] minAccu = new String[5];

            maxAccu[0] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getText();
            minAccu[0] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getText().substring(2);

            maxAccu[1] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getText();
            minAccu[1] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getText().substring(2);

            maxAccu[2] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getText();
            minAccu[2] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getText().substring(2);

            maxAccu[3] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[1]")).getText();
            minAccu[3] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[2]")).getText().substring(2);

            maxAccu[4] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[1]")).getText();
            minAccu[4] = driver.findElement(By.xpath("/html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[2]")).getText().substring(2);

            System.out.println(" Day\t\tMaxTemp\t\tMinTemp");
            for (int i = 0; i < 5; i++) {
                System.out.println("Day " + (i + 1) +"\t\t" +maxAccu[i] + "\t\t\t" + minAccu[i]);
            }

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


