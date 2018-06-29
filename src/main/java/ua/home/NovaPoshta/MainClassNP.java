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


       mainPageNP.clickDeliveryLink();

       DeliveryPageNP deliveryPageNP = new DeliveryPageNP(wd);
        MainPageNP mainPageNP1 = deliveryPageNP.returnMainPage();

//        mainPageNP.clickEstimatedateLink();
//        mainPageNP.clickOfficeLink();
//        mainPageNP.clickTimeTableLink();
//        mainPageNP.clickOnlineOrderLink();
    }

}
