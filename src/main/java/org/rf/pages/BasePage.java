package org.rf.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // daha güvenli bekleme
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
        waitForPageLoad();
        waitThreeSeconds();
    }

    protected void waitForPageLoad() {
        wait.until(driver ->
                ((org.openqa.selenium.JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    protected void waitThreeSeconds() {
        try {
            Thread.sleep(3000); // sabit 3 saniye bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void clickElementWhenClickable(org.openqa.selenium.WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        waitThreeSeconds();
    }
    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitThreeSeconds();
    }
}