package org.example.baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class test2Prices {

    public static void main(String[] args) {

        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mindmeister.com/ru");

        //2 тест: Блок "Цены" содержит несколько тарифов и список часто задаваемых вопросов

        // объявляем переменную и говорим: "Это веб-элемент ЦЕНЫ, он находится по пути xpath..."
        WebElement prices = driver.findElement(By.xpath("//*[@href=\"/ru/mind-map-pricing\"]"));
        prices.click(); //кликаем на этот элемент (ссылка), открывается новая страница в той же вкладке
        // объявляем переменную и говорим: "Это веб-элемент "Часто задаваемые вопросы"", он находится по пути xpath..."
        WebElement oftenQuestions = driver.findElement(By.xpath("//*[@href=\"https://support.mindmeister.com/hc/sections/200303186-Frequently-Asked-Questions\"]"));
        oftenQuestions.click();
        driver.close(); // закрываем браузер
    }
}
