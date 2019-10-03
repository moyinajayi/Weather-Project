package Expleo.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Accuweather {
    private WebDriver driver;
    private WebElement Title;
    @FindBy (how = How.XPATH, using = "/html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]")
        private WebElement Days;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div[2]/div[1]/form/input")
    private WebElement Search;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div/div[3]/a[4]")
    private WebElement Weeksearch;

    public void setSearch(String text){
        Search.click();
        Search.sendKeys(text);
        Search.submit();
        //query.sendKeys(Keys.RETURN)
    }
    public void selectDay(){
        Days.click();
    }
    public void specifyDay(){
        Weeksearch.click();
        }
    public void getTitle(String title){
        title = driver.getTitle();
        System.out.println(title);
    }




}