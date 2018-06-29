package ua.home.NovaPoshtaTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
    public void assertHeading() {
        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);
        String header = estimatedatePage.getHeaderEstimatePage();
        Assert.assertEquals("Терміни доставки",header);

    }

    @After
    public void tearDown() {
        wd.quit();
    }
}
