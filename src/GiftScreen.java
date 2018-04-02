import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftScreen {
    private static WebElement element = null;
    public static WebElement GiftCard(WebDriver driver) {
        element = driver.findElement(By.id("ember1515"));
        return element;
    }
    private static WebElement element1 = null;
    public static WebElement BuyButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-theme']"));
        return element1;
    }
}
