package ua.home.NovaPoshta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;

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
        // описание формы Терміни доставки
        private By  departureDateField = By.xpath(".//input[@id='EstimateDateForm_date']");
        private By  serviceTypeField = By.xpath(".//*[@id='EstimateDateForm_ServiceType']");
        private By  sendercityField = By.xpath(".//*[@id='top_block']/div[1]/div/form/div[1]/div[3]/div[1]/ins") ;
        private By  recipientCityField = By.xpath(".//*[@id='top_block']/div[1]/div/form/div[1]/div[4]/div[1]/ins");
        private By  calcDateButton = By.xpath(".//*[@id='top_block']//input[@value='Розрахувати дату']");
        private By  cleaerFormButton = By.xpath(".//*[@id='top_block']//input[@value='Очистити']");
        private By  validLable = By.xpath(".//*[@id='top_block']//label[@class='l c_l valid']");
        private By  notValidLable = By.xpath("//*[@id='top_block']//label[@class='l c_l invalid']");
        private By  dateResponse = By.xpath(".//*[@id='top_block']//label[text()='Орієнтовна дата доставки']");

        // Описание методов MainPageNP
        public String getHeaderEstimatePage() {
            return wd.findElement(headerEstimatePage).getText();
        }

        public MainPageNP returnMainPage() {
            wd.findElement(mainPagelink).click();
            return new MainPageNP(wd);
        }

        public EstimatedatePage clearDepartureDateField() {
            wd.findElement(departureDateField).clear();
            return this;
        }


        public EstimatedatePage inputDepartureDate(String dateDepartue) {
            wd.findElement(departureDateField).sendKeys(dateDepartue);

            return this;
        }


        public EstimatedatePage inputServiceType(final String nsmeServiseType) {
            wd.findElement(serviceTypeField).click();
            wd.findElement(By.xpath(".//*[@id='top_block']/div[1]/div/form/div[1]/div[2]/div/div/ul/li/span[text()='"+ nsmeServiseType + "']")).click();
            return this;
        }



        public EstimatedatePage inputSenderCity(final String senderCity) {
            wd.findElement(sendercityField).click();
            wd.findElement(By.xpath(".//*[@id='top_block']/div[1]/div/form/div[1]/div[3]/div[1]/div/div/div[1]/ul/li/span[text()='" + senderCity + "']")).click();

            return this;
        }


        public EstimatedatePage inputRecipientCity(String recipientcity) {
            wd.findElement(recipientCityField).click();
            wd.findElement(By.xpath(".//*[@id='top_block']/div[1]/div/form/div[1]/div[4]/div[1]/div/div/div[1]/ul/li/span[text()='" + recipientcity + "']")).click();
            return this;
        }

        public EstimatedatePage inputAllFieldForm(String nameServiceType,String senderCity,String recipientCity) {
            this.inputServiceType(nameServiceType);
            this.inputSenderCity(senderCity);
            this.inputRecipientCity(recipientCity);
            return new EstimatedatePage(wd);
        }


    public EstimatedatePage clearServiceTypeField() {
        wd.findElement(serviceTypeField).clear();
        return this;
    }

        public EstimatedatePage clearSenderVity() {
            wd.findElement(sendercityField).clear();
            return this;
        }

        public EstimatedatePage clearRecipientCity() {
            wd.findElement(recipientCityField).clear();
            return this;
        }

        public EstimatedatePage clearAllFielForm() {
            wd.findElement(cleaerFormButton).click();
            return this;
        }

        public EstimatedatePage clickDateButton() {
            wd.findElement(calcDateButton).click();
            return this;
        }

        public String getLableDateResponse() {
            return wd.findElement(dateResponse).getText();
        }

        public List<WebElement> getValidLabel() {
            return wd.findElements(validLable);
        }

        public List<WebElement> getNotValidLabel() {
            return wd.findElements(notValidLable);
        }

}
