package ua.home.NovaPoshta;

import com.google.common.collect.Lists;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
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
