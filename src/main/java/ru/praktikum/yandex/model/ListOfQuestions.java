package ru.praktikum.yandex.model;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//класс списка вопросов на главной странице
public class ListOfQuestions {
    private WebDriver driver;
    public ListOfQuestions(WebDriver driver) {
        this.driver = driver;
    }
    //метод открытия главной страницы с вопросами
    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // метод ожидания загрузки страницы
    public void waitForOpenPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-0")));
    }
    //закрытие кук
    private By cookButton = By.id("rcc-confirm-button");
    public void clickCookButton() {
        driver.findElement(cookButton).click();
    }

}
