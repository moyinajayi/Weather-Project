package Expleo.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Accuweather {
    private int[] minTemp = new int[5];
    private int[] maxTemp = new int [5];

    private WebElement Days;
    private WebElement Title;


    @FindBy(how = How.XPATH, using = ".//html/body/div/div[1]/div[2]/div[1]/form/input")
    private WebElement Search;

    public void setSearch(String text){
        Search.click();
        Search.sendKeys(text);
    }
    public void selectDay(){
        Days.click();
    }
    public void getTitle(String title){
        System.out.println(title);
    }



    public void getMaxTemp(){
        for(int i=0; i<5; i++){
            System.out.println("Accuweather Day" + (i+1) + ": Maximum Temperature: " + maxTemp[i]);
        }
    }

    public void getMinTemp() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Accuweather Day" + (i + 1) + ": Minimum Temperature:" + minTemp[i]);
        }

    }
}