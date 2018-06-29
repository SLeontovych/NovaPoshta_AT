package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfficePage {
    private WebDriver wd;
    private OfficePage officePage;
    // Создание конструктора страницы
    public OfficePage(WebDriver wd) {
        this.wd = wd;
    }

    // Описание Елементов на странице
    private By headerOfficePage = By.xpath(".//*[@id='wrapper']/h1");
    private By mainPagelink = By.xpath(".//a[@id='logo']");


    // Описание методов
    public String getHeaderOfficePage() {
        return wd.findElement(headerOfficePage).getText();
    }

    public MainPageNP returnMainPage() {
        wd.findElement(mainPagelink).click();
        return new MainPageNP(wd);
    }

}
