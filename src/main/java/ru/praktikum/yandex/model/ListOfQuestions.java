package ru.praktikum.yandex.model;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//класс списка вопросов на главной странице
public class ListOfQuestions {
    private WebDriver driver;
    public ListOfQuestions(WebDriver driver) {
        this.driver=driver;
    }

    //метод открытия главной страницы с вопросами
    public void openPage (){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // метод ожидания загрузки страницы
    public void waitForOpenPage(){new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-0")));
    }

    //элемент, до которого нужно проскролить страницу
    private By scrollElement = By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-7']");

    // метод прокрутки страницы вниз (скролл)
    public void scrollPage (){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",scrollElement);
    }

    //кнопка закрытия кук
    private By cookButton=By.id("rcc-confirm-button");
    public void clickCookButton() {
        driver.findElement(cookButton).click();
    }


    //1-й вопрос
    private By firstQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-0']");

    //1-й ответ
    private By firstAnswer=By.id("accordion__panel-0");

    //метод, отвечающий за клик по 1-ому вопросу вопросу
    public void clickFirstQuestions(){
        driver.findElement(firstQuestion).click();
    }

    //метод получения текста 1-ого вопроса
    public String TextOfFirstQuestion(){
        String textFirst=driver.findElement(firstAnswer).getText();
        return textFirst;
    }

    //метод получения текста 1-ого ответа
    public String textOfFirstAnswer(){
        String textFist=driver.findElement(firstAnswer).getText();
        return textFist;
    }

    //2-й вопрос
    private By secondQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-1']");

    //2-й ответ
    private By secondAnswer=By.id("accordion__panel-1");

    //метод, отвечающий за клик по 2-ому вопросу вопросу
    public void clickSecondQuestions(){
        driver.findElement(secondQuestion).click();
    }

    //метод получения текста 2-ого вопроса
    public String textOfSecondQuestion(){
        String textSecond=driver.findElement(secondQuestion).getText();
        return textSecond;
    }

    //метод получения текста 2-ого ответа
    public String textOfSecondAnswer(){
        String textSecond=driver.findElement(secondAnswer).getText();
        return textSecond;
    }

    //3-й вопрос
    private By thirdQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-2']");

    //3-й ответ
    private By thirdAnswer=By.id("accordion__panel-2");

    //метод, отвечающий за клик по 3-ому вопросу вопросу
    public void clickThirdQuestions(){
        driver.findElement(thirdQuestion).click();
    }

    //метод получения текста 3-ого вопроса
    public String TextOfThirdQuestion(){
        String thirdText=driver.findElement(thirdQuestion).getText();
        return thirdText;
    }

    //метод получения текста 3-ого твета
    public String textOfThirdAnswer(){
        String thirdText=driver.findElement(thirdAnswer).getText();
        return thirdText;
    }

    //4-й вопрос
    private By fourthQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-3']");

    //4-й ответ
    private By fourthAnswer=By.id("accordion__panel-3");

    //метод, отвечающий за клик по 4-ому вопросу вопросу
    public void clickFourthQuestions(){
        driver.findElement(fourthQuestion).click();
    }

    //метод получения текста 4-ого вопроса
    public String TextOfFourthQuestion(){
        String fourthText=driver.findElement(fourthQuestion).getText();
        return fourthText;
    }

    //метод получения текста 4-ого твета
    public String textOfFourthAnswer(){
        String fourthText=driver.findElement(fourthAnswer).getText();
        return fourthText;
    }

    //5-й вопрос
    private By fifthQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-4']");

    //5-й ответ
    private By fifthAnswer=By.id("accordion__panel-4");

    //метод, отвечающий за клик по 5-ому вопросу вопросу
    public void clickFifthQuestions(){
        driver.findElement(fifthQuestion).click();
    }

    //метод получения текста 5-ого вопроса
    public String TextOfFifthQuestion(){
        String fifthText=driver.findElement(fifthQuestion).getText();
        return fifthText;
    }

    //метод получения текста 5-ого твета
    public String textOfFifthAnswer(){
        String fifthText=driver.findElement(fifthAnswer).getText();
        return fifthText;
    }

    //6-й вопрос
    private By sixthQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-5']");

    //6-й ответ
    private By sixthAnswer=By.id("accordion__panel-5");

    //метод, отвечающий за клик по 6-ому вопросу вопросу
    public void clickSixthQuestions(){
        driver.findElement(sixthQuestion).click();
    }

    //метод получения текста 6-ого вопроса
    public String TextOfSixthQuestion(){
        String sixthText=driver.findElement(sixthQuestion).getText();
        return sixthText;
    }

    //метод получения текста 6-ого твета
    public String textOfSixthAnswer(){
        String sixthText=driver.findElement(sixthAnswer).getText();
        return sixthText;
    }

    //7-й вопрос
    private By seventhQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-6']");

    //7-й ответ
    private By seventhAnswer=By.id("accordion__panel-6");

    //метод, отвечающий за клик по 7-ому вопросу вопросу
    public void clickSeventhQuestions(){
        driver.findElement(seventhQuestion).click();
    }

    //метод получения текста 7-ого вопроса
    public String TextOfSeventhQuestion(){
        String seventhText=driver.findElement(seventhQuestion).getText();
        return seventhText;
    }

    //метод получения текста 7-ого твета
    public String textOfSeventhAnswer(){
        String seventhText=driver.findElement(seventhAnswer).getText();
        return seventhText;
    }

    //8-й вопрос
    private By eighthQuestion=By.xpath(".//div[@class='accordion__heading']/div[@id='accordion__heading-7']");

    //8-й ответ
    private By eighthAnswer=By.id("accordion__panel-7");

    //метод, отвечающий за клик по 8-ому вопросу вопросу
    public void clickEighthQuestions(){
        driver.findElement(eighthQuestion).click();
    }

    //метод получения текста 8-ого вопроса
    public String TextOfEighthQuestion(){
        String eighthText=driver.findElement(eighthQuestion).getText();
        return eighthText;
    }

    //метод получения текста 8-ого твета
    public String textOfEighthAnswer(){
        String eighthText=driver.findElement(eighthAnswer).getText();
        return eighthText;
    }

}
