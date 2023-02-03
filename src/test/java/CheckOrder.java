import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.yandex.model.ListOfQuestions;
import ru.praktikum.yandex.model.Order;
import ru.praktikum.yandex.model.OrderSecondPage;

public class CheckOrder {
    private WebDriver driver;

    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "С:\\Users\\Larkov\\.cache\\selenium\\chromedriver\\win32\\109.0.5414.74\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    //положительный тест-кейс по заказу самоката. Проваливается, т.к. нет перехода на статус заказа (кнопка "Да" некликабельна - баг)
    //проверены кнопка "Заказать" вверху первой страницы, кнопка "Эаказать" внизу второй страницы
    public void checkOrderScooter() {
        Order orderScooter = new Order(driver);
        OrderSecondPage orderNext =new OrderSecondPage(driver);
        orderScooter.openPage();
        orderScooter.waitForOpenPage();
        orderScooter.clickCookButton();
        orderScooter.clickOrderButton();
        orderScooter.waitForOpenPage();
        orderScooter.setFirstName("Иван");
        orderScooter.setLastName("Петров");
        orderScooter.setAddress("Улица Варшавская, дом 5, квартира 15");
        orderScooter.clickMetroField();
        orderScooter.waitForOpenListOfStations();
        orderScooter.clickStation();
        orderScooter.setPhoneNumber("79000000000");
        orderScooter.clickNextButton();

        orderNext.setDate("20.02.2023");
        orderNext.clickPeriodOfRentField();
        orderNext.clickChoiceOfRentField();
        orderNext.clickColorOfScooter();
        orderNext.setComment("Тестовый комментарий");
        orderNext.clickOrderDownButton();
        orderNext.clickYesButton();
        orderNext.clickStatusOfOrder();
    }
    @After
    public void teardown() {
        // Закрой браузер
     driver.quit();
    }

    @Test
    //положительный тест-кейс по заказу самоката. Проваливается, т.к. нет перехода на подтверждение заказа с кнопкой "Да"
    //кнопка "Заказать" вверху второй страницы некликабельна - баг
    //проверены кнопка "Заказать" внизу первой страницы, кнопка "Заказать" вверху второй страницы
    public void checkOrderScooterWithDownButton() {
        Order orderScooter = new Order(driver);
        OrderSecondPage orderNext =new OrderSecondPage(driver);
        orderScooter.openPage();
        orderScooter.waitForOpenPage();
        orderScooter.clickCookButton();
        orderScooter.clickOrderDownButton();
        orderScooter.waitForOpenPage();
        orderScooter.setFirstName("Иван");
        orderScooter.setLastName("Петров");
        orderScooter.setAddress("Улица Варшавская, дом 5, квартира 15");
        orderScooter.clickMetroField();
        orderScooter.waitForOpenListOfStations();
        orderScooter.clickStation();
        orderScooter.setPhoneNumber("79000000000");
        orderScooter.clickNextButton();

        orderNext.setDate("20.02.2023");
        orderNext.clickPeriodOfRentField();
        orderNext.clickChoiceOfRentField();
        orderNext.clickColorOfScooter();
        orderNext.setComment("Тестовый комментарий");
        orderNext.clickOrderButton();
        orderNext.clickYesButton();
        orderNext.clickStatusOfOrder();
    }

}
