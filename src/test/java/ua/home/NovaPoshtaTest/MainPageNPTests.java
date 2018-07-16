package ua.home.NovaPoshtaTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.home.NovaPoshta.*;

import java.util.concurrent.TimeUnit;

public class MainPageNPTests {
    private WebDriver wd;
    private MainPageNP mainPageNP;

    @BeforeClass
    public void setUp() {
        String broeser = BrowserType.FIREFOX;
        if (broeser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (broeser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "W:\\TESTER\\WebDriverSel\\Demo_sel\\NovaPoshta_AT\\drivers\\chromedriver.exe");
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://novaposhta.ua");
        mainPageNP = new MainPageNP(wd);

    }


    @AfterMethod
    public void gotoMainPage() {
        wd.get("https://novaposhta.ua");
        mainPageNP = new MainPageNP(wd);
    }

    @Test

    public void clickLinkDelivery() {
        DeliveryPageNP deliveryPageNP = mainPageNP.clickDeliveryLink();
        String heading = deliveryPageNP.getHeaderDeliveryPage();
        Assert.assertEquals("Вартість доставки",heading);
    }

    @Test

    public void clickLinkEstimateDate() {
        EstimatedatePage estimatedatePage = mainPageNP.clickEstimatedateLink();
        String heading = estimatedatePage.getHeaderEstimatePage();
        Assert.assertEquals("Терміни доставки",heading);
    }


    @Test

    public void clickLinkOffice() {
        OfficePage officePage = mainPageNP.clickOfficeLink();
        String heading = officePage.getHeaderOfficePage();
        Assert.assertEquals("Найближче відділення",heading);
    }

    @Test

    public void clickLinkTimeTable() {
        TimeTablePage timeTablePage = mainPageNP.clickTimeTableLink() ;
        String heading = timeTablePage.getHeaderTimeTablePage();
        Assert.assertEquals("Графік роботи відділень",heading);
    }

    @Test
    public void clickLinkOnlineOrder() {
        OnlineOrderPage onlineOrderPage = mainPageNP.clickOnlineOrderLink() ;
        String heading = onlineOrderPage.getHeaderOnlineOrderPage();
        Assert.assertEquals("Виклик кур'єра",heading);
    }


    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}
