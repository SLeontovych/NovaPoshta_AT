package ua.home.NovaPoshta;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


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

        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        wd.manage().window().maximize();
        wd.get("https://novaposhta.ua");
        MainPageNP mainPageNP = new MainPageNP(wd);


        mainPageNP.clickDeliveryLink();
        DeliveryPageNP deliveryPageNP = new DeliveryPageNP(wd);
        deliveryPageNP.inputFormAll(
                "Авангард",
                "Авдіївка",
                "1",
                "2", "3", "4",
                "333");
        boolean exsitInvalidLable = deliveryPageNP.getInvalidField();
        System.out.println("Существуют не заполненые поля: " +  exsitInvalidLable);

        deliveryPageNP.deliveryButtonClick();
        deliveryPageNP.clearButton();

    }
}
