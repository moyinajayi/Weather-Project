package Expleo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Weather24 {
    private WebDriver driver;
    private int[] minTemp = new int[5];
    private int[] maxTemp = new int [5];

    @FindBy(how = How.XPATH, using = "//*[@id=\"ext-gen32\"]")
    private WebElement Days;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]")
    private static WebElement SearchCity;

    @FindBy(how = How.XPATH, using = "//*[@id='ctl00_WeatherContentHolder_ddlCity']/option[19]")
            private WebElement selectCity;

    @FindBy(how= How.XPATH, using = "//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]" )
        private WebElement goButton;

    public void setSearch(){  SearchCity.click(); }
     public void setCity(){   selectCity.click(); }

     public void submitSearch(){ goButton.click(); }
// try days
    public void selectDay(){
        Days.click();
    }
    public void getTitle(String title){
        title = driver.getTitle();
        System.out.println(title);
    }


}

