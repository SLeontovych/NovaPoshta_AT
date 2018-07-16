package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimeTablePage {
    private WebDriver wd;
    private TimeTablePage timeTablePage;
    // Создание конструктора страницы
    public TimeTablePage(WebDriver wd) {
        this.wd = wd;
    }

    // Описание Елементов на странице
    private By headerTimeTablePage = By.xpath(".//*[@id='wrapper']/h1");
    private By mainPagelink = By.xpath(".//a[@title='Головна']");


    // Описание методов MainPageNP
    public String getHeaderTimeTablePage() {
        return wd.findElement(headerTimeTablePage).getText();
    }

    public MainPageNP returnMainPage() {
        wd.findElement(mainPagelink).click();
        return new MainPageNP(wd);
    }
}
