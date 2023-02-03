//Понимаю, что очень топорно проверила данный функционал, но для меня, не имеющей опыта программирования, написать такой тест - уже победа:)
//Хотелось бы попросить, оставлять более развернутые комментарии, чтобы я могла понять, в чем ошибка, и что делать
//Буду благодарна за наводящие вопросы, подсказки:)

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.yandex.model.ListOfQuestions;

public class CheckListOfQuestions {
    private WebDriver driver;

    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "С:\\Users\\Larkov\\.cache\\selenium\\chromedriver\\win32\\109.0.5414.74\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void checkListFirst() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
       //list.scrollPage();
        list.clickFirstQuestions();
        String expected="Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual= list.textOfFirstAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expected, actual);
    }
    @After
    public void cleanUp(){
    driver.quit();
    }

    @Test
    public void checkListSecond() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();;
        list.clickSecondQuestions();
        String expectedSecondText="Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actualSecondText= list.textOfSecondAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expectedSecondText, actualSecondText);
    }

    @Test
    public void checkListThird() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
        list.clickThirdQuestions();
        String expectedThirdText="Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actualThirdText= list.textOfThirdAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expectedThirdText, actualThirdText);
    }
    @Test
    public void checkListFourth() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
        list.clickFourthQuestions();
        String expectedFourthText="Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actualFourthText= list.textOfFourthAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expectedFourthText, actualFourthText);
    }
    @Test
    public void checkListFifth() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
        list.clickFifthQuestions();
        String expectedFifthText="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actualFifthText= list.textOfFifthAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expectedFifthText, actualFifthText);
    }
    @Test
    public void checkListSixth() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
        list.clickSixthQuestions();
        String expectedSixthText="Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actualSixthText= list.textOfSixthAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expectedSixthText, actualSixthText);
    }
    @Test
    public void checkListSeventh() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
        list.clickSeventhQuestions();
        String expectedSeventhText="Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actualSeventhText= list.textOfSeventhAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expectedSeventhText, actualSeventhText);
    }
    @Test
    public void checkListEighth() {
        ListOfQuestions list = new ListOfQuestions(driver);
        list.openPage();
        list.waitForOpenPage();
        list.clickCookButton();
        list.clickEighthQuestions();
        String expectedEighthText="Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actualEighthText= list.textOfEighthAnswer();
        Assert.assertEquals("Ответ не соответствует вопросу", expectedEighthText, actualEighthText);
    }
}
