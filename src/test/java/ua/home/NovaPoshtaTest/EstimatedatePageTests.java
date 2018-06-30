package ua.home.NovaPoshtaTest;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.home.NovaPoshta.EstimatedatePage;
import ua.home.NovaPoshta.MainPageNP;

import java.util.concurrent.TimeUnit;

public class EstimatedatePageTests {
    private WebDriver wd;
    private MainPageNP mainPageNP;
    @Before
    public void setUp() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://novaposhta.ua");
        mainPageNP = new MainPageNP(wd);
        mainPageNP.clickEstimatedateLink();

    }

    @Test
    @Ignore
    public void assertHeading() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        String header = estimatedatePage.getHeaderEstimatePage();
        Assert.assertEquals("Терміни доставки",header);

    }


    @Test
    @Ignore
    public void enterServiceType() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputServiceType("Адреса-Відділення");
        Assert.assertEquals(1,estimatedatePage.getValidLabel().size()) ;
    }

    @Test
    @Ignore
    public void enterSenderCity() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputSenderCity("Авангард");
        Assert.assertEquals(1,estimatedatePage.getValidLabel().size()) ;
    }

    @Test
    @Ignore
    public void enterRecipientCity() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputRecipientCity("Аджамка");
        Assert.assertEquals(1,estimatedatePage.getValidLabel().size()) ;
    }

    @Test
    public void enterAllFieldForm() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        estimatedatePage.inputServiceType("Адреса-Відділення");
        estimatedatePage.inputSenderCity("Авангард");
        estimatedatePage.inputRecipientCity("Аджамка");
    }



    @After
    public void tearDown() {
        wd.quit();
    }
}
