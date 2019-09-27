package Expleo.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Accuweather {
    private WebElement minTemp;
    private WebElement maxTemp;
    private WebElement Days;
    private WebElement Title;


    @FindBy(how = How.XPATH, using = ".//html/body/div/div[1]/div[2]/div[1]/form/input")
    private WebElement Search;
    @FindBy(how = How.XPATH, using = ".//html/body/div/div[1]/div[2]/div[2]/div[2]")
    private WebElement City;

    public void setSearch(String text){
        Search.click();
        Search.clear();
        Search.sendKeys(text);
    }
    public void selectDay(String text){
        Days.clear();
        Days.sendKeys(text);
    }

    public void getMinTemp(String text){
        minTemp.clear();
        minTemp.sendKeys(text);
    }

    public void getMaxTemp(String text){
        maxTemp.clear();
        maxTemp.sendKeys(text);

    }
    public void printCityname(){
        City.getTagName();
    }
    public void printCityTemp(){
        City.getLocation();
    }
}