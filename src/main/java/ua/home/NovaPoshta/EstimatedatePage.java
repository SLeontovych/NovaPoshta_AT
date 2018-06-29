package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstimatedatePage {
    private WebDriver wd;
    private EstimatedatePage estimatedatePage;
    // Создание конструктора страницы
    public EstimatedatePage(WebDriver wd) {
        this.wd = wd;
    }

        // Описание Елементов на странице
        private By headerEstimatePage = By.xpath(".//*[@id='wrapper']/h1");
        private By mainPagelink = By.xpath(".//a[@title='Головна']");


        // Описание методов MainPageNP
        public String getHeaderEstimatePage() {
            return wd.findElement(headerEstimatePage).getText();
        }

        public MainPageNP returnMainPage() {
            wd.findElement(mainPagelink).click();
            return new MainPageNP(wd);
        }
}
