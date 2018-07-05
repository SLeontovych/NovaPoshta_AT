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
    // елементы формы
    private By deliverysenderCityField = By.xpath(".//*[@id='DeliveryForm_senderCity']");
    private By deliveryrecipientCityField = By.xpath(".//*[@id='DeliveryForm_recipientCity']");
    private By deliveryTechnologyField = By.xpath(".//input[@id='DeliveryForm_deliveryTechnology_id']");
    private By deliveryTechnologyList = By.xpath(".//div[@class='select deliveryTechnology del_type']/div[@class='dropdown']/ul/li");
    private By deliveryWeightField = By.xpath(".//*[@id='DeliveryForm_weight']");
    private By deliveryHeightField = By.xpath(".//*[@id='DeliveryForm_height']");
    private By deliveryWidthField = By.xpath(".//*[@id='DeliveryForm_width']");
    private By deliveryDepthField = By.xpath(".//*[@id='DeliveryForm_depth']");
    private By deliveryPlacesCountField = By.xpath(".//input[@id='DeliveryForm_places_count']");
    private By deliveryPublicPriceField = By.xpath(".//input[@id='DeliveryForm_publicPrice']");
    private By deliveryPackingServiceCheckBox = By.xpath(".//*[@id='DeliveryForm_packing_service']");
    private By deliverybackDeliveryCheckBox = By.xpath(".//*[@id='DeliveryForm_backDelivery']");
    private By deliveryCalcButton = By.xpath(".//input[@value='Рассчитать стоимость']");
    private By deliveryClearAllFieldButton = By.xpath(".//input[@value='Очистить']");
    private By deliveryInvalidElemrtsList = By.xpath(".//label[contains(@class,'invalid')]");
    private By deliveryValidElementsList = By.xpath(".//label[contains(@class,' valid')]");




    // Описание методов MainPageNP
    public String getHeaderDeliveryPage() {
        return wd.findElement(headerDeliveryPage).getText();
    }

    public MainPageNP returnMainPage() {
        wd.findElement(mainPagelink).click();
        return new MainPageNP(wd);
    }

}
