package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineOrderPage {
    private WebDriver wd;
    private OnlineOrderPage onlineOrderPage;
    // Создание конструктора страницы
    public OnlineOrderPage(WebDriver wd) {
        this.wd = wd;
    }

    // Описание Елементов на странице
    private By headerOnlineOrderPage = By.xpath(".//*[@id='wrapper']/h1");
    private By mainPagelink = By.xpath(".//a[@title='Головна']");


    // Описание методов
    public String getHeaderOnlineOrderPage() {
        return wd.findElement(headerOnlineOrderPage).getText();
    }

    public MainPageNP returnMainPage() {
        wd.findElement(mainPagelink).click();
        return new MainPageNP(wd);
    }
}
