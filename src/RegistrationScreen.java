import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationScreen {
    private static WebElement element = null;
    public static WebElement RegistrationButton(WebDriver driver){
        element = driver.findElement(By.xpath("//span[@class='seperator-link']"));
        return element;
    }
    private static WebElement element1 = null;
    public static WebElement NotRegistrated(WebDriver driver){
        element1=driver.findElement(By.xpath("//*[@id=\"auth-modal\"]/div/span"));
        return element1;
        }
    private static WebElement element2 = null;
    public static WebElement PressConfirm (WebDriver driver){
        element2 = driver.findElement(By.xpath("//*[@id=\"ember855\"]/div[5]/div/label"));
        return element2;
    }
    private static WebElement element3=null;
    public static WebElement PressLogin(WebDriver driver){
        element3= driver.findElement(By.xpath("//*[@id=\"ember855\"]/button"));
        return element3;
    }



}
