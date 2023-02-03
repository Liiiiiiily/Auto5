package org.example.baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class test4RealYoutubeGuides {

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

        //4 тест: Страница вебинаров содержит действующие ссылки на Youtube-видео специалистов


        //1) Кликнуть на кнопку "Продукт" в хедере.
        WebElement products = driver.findElement(By.id("btn-product-dropdown"));
        products.click();
        //2) Выбрать и открыть ссылку "Вебинары"
        WebElement webinars = driver.findElement(By.linkText("Вебинары"));
        webinars.click();
//        3) В новой вкладке выбрать первое видео и нажать на белую кнопку проигрывания видео.
//         Проверить, идёт ли видео при нажатии на кнопку "play", не заблокировано ли оно.
        WebElement firstVideo = driver.findElement(By.xpath("//*[@href=\"https://www.mindmeister.com/pages/de/mindmeister-vr-wurzburg-webinar/\"]"));
        firstVideo.click();
        WebElement playButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playButton.click();
        driver.close();
//        4) Повторить пункт 3) с остальными видео на данной странице.
//         вариант перебора всех видео ДЛИННЕЕ
        WebElement secondVideo = driver.findElement(By.xpath("//*[@href=\"https://youtu.be/AOdK3PCfuMI\"]"));
        secondVideo.click();
        WebElement secondPlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        secondPlayButton.click();
        driver.close();
        WebElement thirdVideo = driver.findElement(By.xpath("//*[@href=\"https://vimeo.com/545102751/387ab3ff58\"]"));
        thirdVideo.click();
        WebElement thirdPlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        thirdPlayButton.click();
        driver.close();
        WebElement fourthVideo = driver.findElement(By.xpath("//*[@href=\"https://youtu.be/wJFG1GbeaAA\"]"));
        fourthVideo.click();
        WebElement fourthPlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        fourthPlayButton.click();
        driver.close();
        WebElement fifthVideo = driver.findElement(By.xpath("//*[@]href=\"https://youtu.be/KDUdYn84_30\""));
        fifthVideo.click();
        WebElement fifthPlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        fifthPlayButton.click();
        driver.close();
        WebElement sixthVideo = driver.findElement(By.xpath("//*[@]href=\"https://youtu.be/mgp20KuenE4\""));
        sixthVideo.click();
        WebElement sixthPlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        sixthPlayButton.click();
        driver.close();
        WebElement seventhVideo = driver.findElement(By.xpath("//*[@]href=\"https://youtu.be/laEjoSbO1UA\""));
        seventhVideo.click();
        WebElement seventhPlayButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        seventhPlayButton.click();
        driver.close();
    }
}

//// или вариант перебора всех видео КОРОЧЕ
//        List<String> video = List.of("панамка-синяя", "кепка-большая", "шляпа с пером");
//        for(String videos : video) {
//            video.click();
//            WebElement playButton = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
//            playButton.click();
//            driver.close();
//        }
//        driver.quit(); // закрываем браузер
//
//// Построим цепочку действий
//        builder
//                .click() // кликаем на первую строчку
//                .build() // завершаем формирование цепочки действий
//                .perform();
//    }
//}