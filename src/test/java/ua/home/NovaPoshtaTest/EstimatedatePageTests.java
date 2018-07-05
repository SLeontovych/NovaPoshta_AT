package ua.home.NovaPoshtaTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.home.NovaPoshta.EstimatedatePage;
import ua.home.NovaPoshta.MainPageNP;

import java.util.concurrent.TimeUnit;

public class EstimatedatePageTests {
    private WebDriver wd;
    private MainPageNP mainPageNP;

    @BeforeClass
    public void setUp() {
        String browser = BrowserType.FIREFOX;

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "W:\\TESTER\\WebDriverSel\\Demo_sel\\NovaPoshta_AT\\drivers\\chromedriver.exe");
            wd = new ChromeDriver();
        }
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://novaposhta.ua");


    }

    @BeforeMethod
    public void createObjectnMainPage() {
        mainPageNP = new MainPageNP(wd);
        mainPageNP.clickEstimatedateLink();
    }

    @Test
    public void assertHeading() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        String header = estimatedatePage.getHeaderEstimatePage();
        Assert.assertEquals("Терміни доставки",header);

    }


    @Test
    public void enterServiceType() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputServiceType("Адреса-Відділення");
        Assert.assertEquals(1,estimatedatePage.getValidLabel().size()) ;
    }

    @Test
    public void enterSenderCity() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputSenderCity("Авангард");
        Assert.assertEquals(1,estimatedatePage.getValidLabel().size()) ;
    }

    @Test
    public void enterRecipientCity() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputRecipientCity("Аджамка");
        Assert.assertEquals(1,estimatedatePage.getValidLabel().size()) ;
    }

    @Test
    public void enterAllFieldForm() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputAllFieldForm("Адреса-Відділення","Авангард","Аджамка");
        Assert.assertEquals(3,estimatedatePage.getValidLabel().size()) ;
    }

    @Test
    public void calcDateEstimate() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputAllFieldForm("Адреса-Відділення","Авангард","Аджамка");
        estimatedatePage.clickDateButton();
        Assert.assertEquals("Орієнтовна дата доставки",estimatedatePage.getLableDateResponse()) ;
    }

    @Test
    public void calcDateEmptyAllField() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.clickDateButton();
        Assert.assertEquals(3,estimatedatePage.getNotValidLabel().size()) ;
    }

    @Test
    public void clearAllField() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputAllFieldForm("Адреса-Відділення","Авангард","Аджамка");
        estimatedatePage.clearAllFielForm();
        estimatedatePage.clickDateButton();
        Assert.assertEquals(3,estimatedatePage.getNotValidLabel().size()) ;
    }

    @AfterMethod
    public MainPageNP gotoMainPage() {
        MainPageNP mainPageNP = new EstimatedatePage(wd).returnMainPage();
        return new MainPageNP(wd);
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}
