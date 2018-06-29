package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryPageNP {
    private WebDriver wd;
    private DeliveryPageNP deliveryPageNP;
    // Создание конструктора страницы
    public DeliveryPageNP(WebDriver wd) {
        this.wd = wd;
    }

    // Описание Елементов на странице
    private By headerDeliveryPage = By.xpath(".//*[@id='wrapper']/h1");
    private By mainPagelink = By.xpath(".//a[@title='Головна']");

    // Описание методов MainPageNP
    public String getHeaderDeliveryPage() {
        return wd.findElement(headerDeliveryPage).getText();
    }

    public MainPageNP returnMainPage() {
        wd.findElement(mainPagelink).click();
        return new MainPageNP(wd);
    }

}
