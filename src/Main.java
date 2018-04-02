import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Main {
    private static WebDriver driver;
    public  String getData;
    @Rule
    public TestName name = new TestName();
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public static void Browsers() throws Exception {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\אדם גת דולה\\Desktop//extent.html");
        htmlReporter.setAppendExisting(true);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Buyme project", "Final web project");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Tester", "RAN&ADAM");
        test.log(Status.INFO, "@Before class");



        String BrowserType = getData("BrowserType");
        if (BrowserType.equals("Chrome")) {
            System.out.println("Chrome");
            System.setProperty("webdriver.chrome.driver", "C:\\automiton\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://buyme.co.il/");

        } else if (BrowserType.equals("firefox")) {
            System.out.println("firefox");
            System.setProperty("webdriver.gecko.driver", "C:\\automiton\\geckodriver-v0.19.1-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://buyme.co.il/");


        } else if (BrowserType.equals("IE")) {
            System.out.println("IE");
            System.setProperty("webdriver.ie.driver", "C:\\automiton\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://buyme.co.il/");

        }
    }

          private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
            File Browsers = new File("C:\\Users\\אדם גת דולה\\Desktop\\Browsers.XML");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = null;

            assert dBuilder != null;
            doc = dBuilder.parse(Browsers);

            if (doc != null) {
                doc.getDocumentElement().normalize();
            }
            assert doc != null;
            return doc.getElementsByTagName(keyName).item(0).getTextContent();
        }

        @Test
        public void Registration () {
            boolean registrationApproved = false;
            try {
                RegistrationScreen.RegistrationButton(driver).click();
                RegistrationScreen.NotRegistrated(driver).click();
                driver.findElement(By.id(Constants.FIRST_NAME)).sendKeys("Adam");
                driver.findElement(By.id(Constants.EMAIL)).sendKeys("adam.gatdula154@gmail.com"); //change mail every run
                driver.findElement(By.id(Constants.PASSWORD)).sendKeys("123456");
                driver.findElement(By.id(Constants.REPASSWORD)).sendKeys("123456");
                RegistrationScreen.PressConfirm(driver).click(); // check xpath
                RegistrationScreen.PressLogin(driver).click(); // check xpath
            } catch (Exception e) {
                e.printStackTrace();
                test.log(Status.FAIL, "Registration failed" + e.getMessage());
                registrationApproved = false;
            } finally {
                if (registrationApproved) {
                    test.log(Status.PASS, "Registration went succesfully");
                }
            }
        }

        @Test
        public void homePage () {
            boolean homePageLogin= false;
            try {
            HomeScreen.ChoosePrice(driver).click();
            HomeScreen.Choose99(driver).click();
            HomeScreen.ChooseArea(driver).click();
            HomeScreen.TLV(driver).click();
            HomeScreen.ChooseCategoryButton(driver).click();
            HomeScreen.CategoryOption(driver).click();
            HomeScreen.SearchButton(driver).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }catch (Exception e){
                e.printStackTrace();
                test.log(Status.FAIL,"Login fail"+e.getMessage());
                homePageLogin=false;
            }finally {
                if (homePageLogin){
                    test.log(Status.PASS,"Login went throgh succesfuly");
                }
            }
        }



        @Test
        public void chooseGift () {
            System.out.println(driver.getCurrentUrl());
            Assert.assertEquals("www.buyme.co.il", "https://buyme.co.il/search?budget=1&category=22&region=13");
            GiftScreen.GiftCard(driver).click();
            driver.findElement(By.id(Constants.AMOUNT)).sendKeys("99");
            GiftScreen.BuyButton(driver).submit();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        @Test
        public void informationScreen () {
            driver.findElement(By.id(Constants.RECIVER)).sendKeys("Daniel Gotllib");
            SendScreen.Event(driver).click();
            SendScreen.EventKind(driver).click();
            driver.findElement(By.id(Constants.BLESSING)).sendKeys("Congrats for the end of the project");
            driver.findElement(By.name("fileUpload")).sendKeys("<C:\\Users\\אדם גת דולה\\Desktop.pic>");
            SendScreen.SendNow(driver).click();
            SendScreen.SendBy(driver).click();
            driver.findElement(By.id(Constants.PHONENUMBER)).sendKeys("054-5288658");
            driver.findElement(By.id(Constants.PHONERECIVER)).sendKeys("054-5555555");
            SendScreen.PressSave(driver).submit();
        }
        @AfterClass
        public static void afterClass(){
        test.log(Status.INFO,"@After test"+"After test method");
        //  driver.quit();
        extent.flush();
    }
}



