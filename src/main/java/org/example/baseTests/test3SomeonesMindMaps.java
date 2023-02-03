package org.example.baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class test3SomeonesMindMaps {

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

        //3 тест: Зарегистрированный пользователь может сохранить карту другого пользователя
//1) Перейти на футер лендинга, открыть ссылку "Каталог карт".
        WebElement mapCatalog = driver.findElement(By.xpath("//*[@href=\"/ru/mind-map-examples\"]"));
        mapCatalog.click(); //кликаем на этот элемент (ссылка)
//2) Из перечня готовых карт других пользователей выбираем одну любую. Открываем её.
        WebElement anyMindCap = driver.findElement(By.xpath("//*[@href=\"/ru/1122589003/the-key-components-of-knowledge-management\"]"));
        anyMindCap.click();
//3) Нажимаем на кнопку "Копировать/изменить".
        WebElement copyButton = driver.findElement(By.xpath("//*[@class=\"pill-button secondary h-flex-row h-hover-shine ml-20\"]"));
        copyButton.click();
//4) Регистрируемся удобным способом (через Google-аккаунт).
        WebElement authenticationToGoogle = driver.findElement(By.id("btn_signin_google"));
        authenticationToGoogle.click();
//5) В обновлённой вкладке снова нажимаем на кнопку "Копировать/изменить" ("Copy and edit map"). В открывшемся окне "Copy public map" нажимаем "Ok".
        copyButton.click();
        WebElement nextOkButton = driver.findElement(By.xpath("//*[@class=\"button ok_button default\"]"));
        nextOkButton.click();
//6) Нажать на кнопку "Map listing". Найти в перечне своих карт скопированную карту.
        WebElement mapListing = driver.findElement(By.xpath("//*[@d=\"M10.78 12.375a1 1 0 0 1-1.56 1.25l-4-5a1 1 0 0 1 0-1.25l4-5a1 1 0 0 1 1.56 1.25L7.28 8l3.5 4.375z\"]"));
        mapListing.click();
        driver.close();
    }
}

// или другой адрес для кнопки mapListing
// style="display: inline-flex; justify-content: center; align-items: center; width: 100%; height: 24px; padding: 4px;
// border-radius: 12px; cursor: pointer; white-space: nowrap; border-width: 0px; border-color: rgb(61, 71, 77);
// background-color: rgba(0, 0, 0, 0); opacity: 1; backface-visibility: hidden; transform: scaleX(1) scaleY(1);"

