package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    // елементы формы

    // Описание методов MainPageNP
    public String getHeaderDeliveryPage() {
        return wd.findElement(headerDeliveryPage).getText();
    }

    // Описание формы Cost
    // **************************************************
    public DeliveryPageNP inputFormAll(String senderCity, String recipientCity, String weight, String height, String width, String depth, String price) {
        inputRoute(senderCity, recipientCity);
        inputWeight(weight);
        inputDemensions(height, width, depth);
        inputPublicPrice(price);
        return this;
    }

    private void inputPublicPrice(String price) {
        By locatorPublicPrice = By.id("DeliveryForm_publicPrice");
        inputField(price, locatorPublicPrice);
    }

    private void inputDemensions(String height, String width, String depth) {
        By locatorHeight = By.id("DeliveryForm_height");
        By locatorWidth  = By.id("DeliveryForm_width");
        By locatorDepth  = By.id("DeliveryForm_depth");
        inputField(height, locatorHeight);
        inputField(width, locatorWidth);
        inputField(depth, locatorDepth);
    }

    private void inputWeight(String weight) {
        By locatorWeight = By.id("DeliveryForm_weight");
        inputField(weight, locatorWeight);
    }

    private void inputField(String price, By locator) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(price);
    }

    private void inputRoute(final String senderCity, final String recipientCity) {
        wd.findElement(By.xpath(".//*[@for='DeliveryForm_senderCity']/parent::div/ins")).click();
        wd.findElement(By.xpath("//div[@class='jspPane']//span[.='" + senderCity + "']")).click();
        wd.findElement(By.xpath(".//label[@for='DeliveryForm_recipientCity']/parent::div/ins")).click();
        wd.findElement(By.xpath("//div[@class='jspPane']//span[.='" + recipientCity + "']")).click();
    }

    public DeliveryPageNP deliveryButtonClick() {
        wd.findElement(By.xpath(".//input[@value='Розрахувати вартість']")).click();
        return this;
    }

    public DeliveryPageNP clearButton() {
        wd.findElement(By.xpath(".//input[@value='Очистити']")).click();
        return this;
    }

    public Boolean getInvalidField() {
        List<WebElement> listLable = wd.findElements(By.xpath(".//*[contains(@class,'invalid')]"));
        if (listLable.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public MainPageNP returnMainPage() {
        wd.findElement(mainPagelink).click();
        return new MainPageNP(wd);
    }

}
