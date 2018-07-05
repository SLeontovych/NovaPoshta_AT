package ua.home.NovaPoshta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class MainClassNP {
    static WebDriver wd;

    public static void main(String[] args) {
        String broeser = org.openqa.selenium.remote.BrowserType.FIREFOX;

        if (broeser == org.openqa.selenium.remote.BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        } else if ( broeser == org.openqa.selenium.remote.BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", "W:\\TESTER\\WebDriverSel\\Demo_sel\\NovaPoshta_AT\\drivers\\chromedriver.exe");
            wd = new ChromeDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        wd.manage().window().maximize();
        wd.get("https://novaposhta.ua");
        MainPageNP mainPageNP = new MainPageNP(wd);


        mainPageNP.clickEstimatedateLink();

        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);

//        estimatedatePage.inputDepartureDate("01.01.2018");
//        estimatedatePage.inputServiceType("Адреса-Адреса");
//          estimatedatePage.inputSenderCity("Авдіївка");
        estimatedatePage.inputRecipientCity("Аджамка");
//        estimatedatePage.clickDateButton();
//        List validLabel = estimatedatePage.getValidLabel();
//        List notValidLabel = estimatedatePage.getNotValidLabel();
//        estimatedatePage.clearAllFielForm();

//        System.out.println("Valid Label: " + validLabel.size());
//        System.out.println("Not Valid Label: " + notValidLabel.size());
    }
}
