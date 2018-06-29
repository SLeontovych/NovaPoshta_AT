package ua.home.NovaPoshta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClassNP {
    static WebDriver wd;

    public static void main(String[] args) {

        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://novaposhta.ua");
        MainPageNP mainPageNP = new MainPageNP(wd);


        mainPageNP.clickEstimatedateLink();

        EstimatedatePage estimatedatePage = new EstimatedatePage(wd);

//        estimatedatePage.inputDepartureDate("01.01.2018");
        estimatedatePage.inputServiceType("Адреса-Адреса");
        estimatedatePage.inputSenderCity("Авдіївка");
        estimatedatePage.inputRecipientCity("Аджамка");
//        estimatedatePage.clearAllFielForm();
        estimatedatePage.clickDateButton();
        System.out.println(estimatedatePage.getLableDateResponse());
    }
}
