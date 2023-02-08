import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.yandex.model.Order;
import ru.praktikum.yandex.model.OrderSecondPage;

@RunWith(Parameterized.class)
public class CheckOrderScooter {
    private By topButton;
    private By downButton;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String date;
    private String comment;

    public CheckOrderScooter (By topButton, By downButton, String firstName, String lastName, String address, String phoneNumber, String date, String comment) {
        this.topButton = topButton;
        this.downButton = downButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.comment = comment;
    }
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Parameterized.Parameters
    public static Object[][] fillData() {
        return new Object[][]{
                {By.className("Button_Button__ra12g"), By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']"),"Иван", "Петров", "Улица Варшавская, дом 5, квартира 15", "79000000000", "20.02.2023", "Тестовый комментарий"},
                {By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"), By.xpath(".//button[@class='Button_Button__ra12g']"), "Иван", "Петров", "Улица Варшавская, дом 5, квартира 15", "79000000000", "20.02.2023", "Тестовый комментарий" },
        };
    }
    @Test
    //положительный тест-кейс по заказу самоката. Проваливается, т.к. нет перехода на статус заказа (кнопка "Да" некликабельна - баг)
    //проверены кнопка "Заказать" вверху первой страницы, кнопка "Заказать" внизу второй страницы
    //проверены кнопка "Заказать" внизу первой страницы, кнопка "Заказать" вверху второй страницы
    public void checkOrderScooter() {
        Order orderScooter = new Order(driver);
        OrderSecondPage orderNext = new OrderSecondPage(driver);
        orderScooter.openPage();
        orderScooter.waitForOpenPage();
        orderScooter.clickCookButton();
        driver.findElement(topButton).click();
        orderScooter.waitForOpenPage();
        orderScooter.setFirstName(firstName);
        orderScooter.setLastName(lastName);
        orderScooter.setAddress(address);
        orderScooter.clickMetroField();
        orderScooter.waitForOpenListOfStations();
        orderScooter.clickStation();
        orderScooter.setPhoneNumber(phoneNumber);
        orderScooter.clickNextButton();

        orderNext.setDate(date);
        orderNext.clickPeriodOfRentField();
        orderNext.clickChoiceOfRentField();
        orderNext.clickColorOfScooter();
        orderNext.setComment(comment);
        driver.findElement(downButton).click();
        orderNext.clickYesButton();
        orderNext.clickStatusOfOrder();
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
