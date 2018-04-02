import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeScreen {
    private static WebElement element = null;
    public static WebElement ChoosePrice(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='chosen single' and @tab index='-1']"));
        return element;
    }
    private static WebElement element1 = null;
    public static WebElement Choose99 (WebDriver driver){
        element1=driver.findElement(By.xpath("//Ii[@class='active-result-result selected and @index='1']"));
        return element1;
    }
    private static WebElement element2 = null;
    public static WebElement ChooseArea (WebDriver driver){
        element1=driver.findElement(By.id("ember619"));
        return element2;
    }
    private static WebElement element3 = null;
    public static WebElement TLV (WebDriver driver) {
        element1 = driver.findElement(By.xpath("//option[@value='1']"));
        return element3;
    }
    private static WebElement element4 = null;
    public static WebElement ChooseCategoryButton (WebDriver driver) {
        element1 = driver.findElement(By.id("ember628"));
        return element4;
    }
    private static WebElement element5 = null;
    public static WebElement CategoryOption (WebDriver driver) {
        element1 = driver.findElement(By.xpath("//option[@value='22']"));
        return element5;
    }
    private static WebElement element6 = null;
    public static WebElement SearchButton (WebDriver driver) {
        element1 = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary fluid']"));
        return element6;

    }
}
