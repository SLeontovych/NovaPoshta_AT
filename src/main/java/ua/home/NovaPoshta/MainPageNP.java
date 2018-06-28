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
    private By deliveryLink = By.xpath(".//span[text()='Вартість доставки'");
    private By estimatedateLink = By.xpath(".//span[text()='Терміни доставки']");
    private By officeLink = By.xpath(".//span[text()='Найближче відділення']");
    private By timetableLink = By.xpath("Графік роботи відділень");
    private By onlineorderLink = By.xpath(".//span[text()=\"Виклик кур'єра\"]");

    // Описание методов MainPageNP

    public DeliveryPageNP clickDeliveryLink() {
        wd.findElement(deliveryLink).click();
        return new DeliveryPageNP(wd);

    }


}
