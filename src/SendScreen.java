import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendScreen {
    private static WebElement element = null;
    public static WebElement Event(WebDriver driver) {
        element = driver.findElement(By.id("ember1579"));
        return element;
    }
    private static WebElement element1 = null;
    public static WebElement EventKind(WebDriver driver) {
        element = driver.findElement(By.xpath("//option[@value='10']"));
        return element1;
    }
    private static WebElement element2 = null;
    public static WebElement SendNow(WebDriver driver) {
        element = driver.findElement(By.xpath("//label[@class= 'send-now']"));
        return element2;
    }
    private static WebElement element3 = null;
    public static WebElement SendBy(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='icon icon-sms']"));
        return element3;
    }
    private static WebElement element4= null;
    public static WebElement PressSave(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-theme btn-save']"));
        return element4;
    }
}
