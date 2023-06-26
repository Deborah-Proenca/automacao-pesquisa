package org.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.out.println("Start tests");
        WebDriver driver = new ChromeDriver();
        SearchElement searchElement = new SearchElement(driver);
        driver.manage().window().maximize();

        searchPostSuccessTest(driver, searchElement);
        searchRandomResultSuccessTest(driver, searchElement);

        closeProject(driver);
    }

    private static void closeProject(WebDriver driver) {
        driver.quit();
        System.out.println("Finish tests");
    }

    private static void searchPostSuccessTest(WebDriver driver, SearchElement searchElement) {
        System.out.println("TEST 1 - searchPostSuccessTest - Start");
        driver.get("https://blogdoagi.com.br/");
        WebElement lupe = searchElement.getLupe();
        lupe.click();

        WebElement search = searchElement.getSearch();
        search.sendKeys("Programa de estágio do Agi terá vagas para todas áreas; veja como se candidatar.");
        search.submit();

        WebElement firstResult = searchElement.getFirstResult();

        Assert.assertEquals("Programa de estágio do Agi terá vagas para todas áreas; veja como se candidatar.",
                firstResult.getText());
    }

    private static void searchRandomResultSuccessTest(WebDriver driver, SearchElement searchElement) {
        System.out.println("TEST 2 - searchEmptyResultSuccessTest - Start");
        driver.get("https://blogdoagi.com.br/");
        WebElement lupe = searchElement.getLupe();
        lupe.click();
        WebElement search = searchElement.getSearch();
        search.sendKeys("busca aleatoria");
        search.submit();

        WebElement firstResult = searchElement.getNotFound();

        Assert.assertEquals("Nenhum resultado",
                firstResult.getText());
    }
}