import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.yandex.model.ListOfQuestions;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class  CheckListOfQuestionAndAnswers {
    private By questions; // вопросы на странице
    private By getTextOfAnswers; // ответы на соответствующие вопросы
    private String expected; //ожидаемый текст ответа
    public CheckListOfQuestionAndAnswers (By questions, By getTextOfAnswers, String expected){
        this.questions=questions;
        this.getTextOfAnswers=getTextOfAnswers;
        this.expected=expected;
    }
        private WebDriver driver;
        @Before
        public void startUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
        @Parameterized.Parameters
        public static Object[][] textOfQuestionsAndAnswers () {
        return new Object[][]{
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-0']"), By.id("accordion__panel-0"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-1']"), By.id("accordion__panel-1"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-2']"), By.id("accordion__panel-2"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-3']"), By.id("accordion__panel-3"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-4']"), By.id("accordion__panel-4"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-5']"), By.id("accordion__panel-5"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-6']"), By.id("accordion__panel-6"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-7']"), By.id("accordion__panel-7"), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
        @Test
        public void checkList () {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
        // скролиннг страницы до блока "Вопросы"
        WebElement element = driver.findElement(By.className("accordion"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        // клик по соответствующему вопросу
        driver.findElement(questions).click();
        // получение текста ответа на соответствующий вопрос
        String text=driver.findElement(getTextOfAnswers).getText();
        // сравнение полученного ответа и ожидаемого ответа
        assertEquals(expected, text);
    }
        @After
        public void cleanUp () {
            driver.quit();
    }
}

