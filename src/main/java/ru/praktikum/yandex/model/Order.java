package ru.praktikum.yandex.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// класс заказа самоката
public class Order {
    private WebDriver driver;
    public Order(WebDriver driver) {

        this.driver=driver;
    }

    //метод открытия главной страницы с вопросами
    public void openPage (){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //кнопка закрытия кук
    private By CookButton=By.id("rcc-confirm-button");
    public void clickCookButton() {
        driver.findElement(CookButton).click();
    }


    // локатор верхней кнопки "Заказать"
    private By orderButton=By.className("Button_Button__ra12g");

    // локатор нижней кнопки "Заказать"
    private By orderDownButton=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // метод ожидания загрузки страницы
    public void waitForOpenPage(){new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("Button_Button__ra12g")));
    }

    //метод клика на кнопку "Заказать", кнопка находится вверху
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    //метод клика на кнопку "Заказать", кнопка находится внизу страницы
    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();
    }

    // локатор "Имя"
    private By firstNameField=By.xpath(".//input[@placeholder='* Имя']");
    // локатор "Фамилия"
    private By lastNameField=By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор "Адреса"
    private By addressField=By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор "Станция метро"
    private By metroField=By.xpath(".//input[@placeholder='* Станция метро']");
    // локатор "Телефон"
    private By phoneNumberField=By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private By nextButton = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_NextButton__1_rCA']/button");


    // методы для заполнения поля "Имя"
    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    // методы для заполнения поля "Фамилия"
    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    // методы для заполнения поля "Адрес"
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // кликнуть по полю "Станция метро"
    public void clickMetroField() {
        driver.findElement(metroField).click();
    }
    // дождаться прогрузки списка станций метро
    public void waitForOpenListOfStations(){new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.className("select-search__select")));
    }
    // поиск станции по text
    private By station=By.xpath(".//div[text()='Черкизовская']");
    public void clickStation() {
        driver.findElement(station).click();
    }

    // методы для заполнения поля "Телефон: на него позвонит курьер"
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
