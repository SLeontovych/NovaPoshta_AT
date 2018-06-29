package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageNP {
    private WebDriver wd;

    // Создание конструктора страницы
    public MainPageNP(WebDriver wd) {
        this.wd = wd;
    }

    // Описание Елементов на странице
    private By deliveryLink = By.xpath(".//*[@id='top_block']/div[1]/ul/li[1]/a/span");
    private By estimatedateLink = By.xpath(".//span[text()='Терміни доставки']");
    private By officeLink = By.xpath(".//span[text()='Найближче відділення']");
    private By timetableLink = By.xpath(".//span[text()='Графік роботи відділень']");
    private By onlineorderLink = By.xpath(".//a[@href='/onlineorder']");

    // Описание методов MainPageNP

    public DeliveryPageNP clickDeliveryLink() {
        wd.findElement(deliveryLink).click();
        return new DeliveryPageNP(wd);
    }

    public EstimatedatePage clickEstimatedateLink() {
      wd.findElement(estimatedateLink).click();
      return new EstimatedatePage(wd);
    }

    public OfficePage clickOfficeLink() {
        wd.findElement(officeLink).click();
        return new OfficePage(wd);
    }

    public TimeTablePage clickTimeTableLink() {
        wd.findElement(timetableLink).click();
        return new TimeTablePage(wd);
    }

    public OnlineOrderPage clickOnlineOrderLink() {
        wd.findElement(onlineorderLink).click();
        return new OnlineOrderPage(wd);
    }

}
