package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchElement {
    private WebDriver driver;

    public SearchElement(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLupe() {
        return driver.findElement(By.cssSelector("#search-open"));
    }

    public WebElement getSearch() {
        return driver.findElement(By.cssSelector("#masthead > div.site-header-content > div.desktop-search > form > label > input"));
    }

    public WebElement getNotFound() {
        return driver.findElement(By.cssSelector("#primary > section > header > h1"));
    }

    public WebElement getFirstResult() {
        return driver.findElement(By.cssSelector("#post-1406 > div.meta-main-wrap > div.entry-main > header > h2"));
    }
}
