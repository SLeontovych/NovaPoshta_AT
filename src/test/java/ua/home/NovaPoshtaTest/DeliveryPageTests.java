package ua.home.NovaPoshtaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.home.NovaPoshta.DeliveryPageNP;
import ua.home.NovaPoshta.MainPageNP;

import java.util.concurrent.TimeUnit;

public class DeliveryPageTests {
    private WebDriver wd;
    private MainPageNP mainPageNP;
    private DeliveryPageNP deliveryPageNP;

    @BeforeClass
    public void setUp() {
        String browser = BrowserType.FIREFOX;
        String chromeDriverPAth = "W:\\TESTER\\WebDriverSel\\Demo_sel\\NovaPoshta_AT\\drivers\\chromedriver.exe";

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPAth);
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://novaposhta.ua");
    }

    @BeforeMethod
    public void createObjectnDeliveryPage() {
        mainPageNP = new MainPageNP(wd);
        mainPageNP.clickDeliveryLink();
        deliveryPageNP = new DeliveryPageNP(wd);
    }

    @Test
    public void assertHeading() {
        String header = deliveryPageNP.getHeaderDeliveryPage();
        Assert.assertEquals("Вартість доставки",header);
    }

    @Test
    public void inputFormAllFieldValid() {
        deliveryPageNP.inputFormAll("Авангард","Аджамка","1","2","3","4","11");
        boolean validField = deliveryPageNP.getInvalidField();
        Assert.assertEquals(validField,false);
    }

    @Test
    public void clickDelivaryButton() {
        deliveryPageNP.inputFormAll("Авангард","Аджамка","1","2","3","4","11");
        deliveryPageNP.deliveryButtonClick();
        String deliveryStr = deliveryPageNP.getDeliveryString();
        Assert.assertEquals("Розрахункова вартість доставки",deliveryStr);
    }




    @AfterMethod
    public void gotoMainPage() {
        mainPageNP = new DeliveryPageNP(wd).returnMainPage();
    }


        @AfterClass
    public void tearDown() {
        wd.quit();
    }


}
