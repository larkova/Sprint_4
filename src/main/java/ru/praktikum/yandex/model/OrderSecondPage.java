package ru.praktikum.yandex.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSecondPage {
    private WebDriver driver;

    public OrderSecondPage(WebDriver driver) {

        this.driver = driver;
    }

    // локатор поля "Когда привезти самокат"
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор поля "Срок аренды"
    private By periodOfRentField = By.xpath(".//span[@class='Dropdown-arrow']");
    // локатор выбора периода аренды
    private By choiceOfRentField = By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']");
    // локатор поля "Цвет самоката"
    private By colorOfScooterField = By.id("black");
    //локатор поля "Комментарий для курьера"
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор нижней кнопки "Заказать"
    private By orderDownButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //локатор кнопки "Да"
    private By yesButton=By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    // кнопка "Посмотреть статус"
    private By statusOfOrder=By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Посмотреть статус']");

    // метод заполнения поля "Когда привезти самокат"
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
    public void clickDate  () {
        driver.findElement(dateField).click();
    }

        // метод заполнения поля "Срок аренды"
        public void clickChoiceOfRentField  () {
            driver.findElement(choiceOfRentField).click();
        }
        // клик по полю
        public void clickPeriodOfRentField () {
            driver.findElement(periodOfRentField).click();
        }
        // метод заполнения поля "Цвет самоката"
        public void clickColorOfScooter () {
            driver.findElement(colorOfScooterField).click();
        }
        // метод заполнения поля "Комментарий для курьера"
        public void setComment (String comment){
                driver.findElement(commentField).sendKeys(comment);
        }
        // клик по кнопке "Да"
        public void clickYesButton () {
            driver.findElement(yesButton).click();
        }
    // клик по кнопке "Посмотреть статус"
        public void clickStatusOfOrder () {
        driver.findElement(statusOfOrder).click();
    }
}

