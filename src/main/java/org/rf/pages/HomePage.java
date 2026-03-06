package org.rf.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {

    @FindBy(className = "gender-card-action")
    WebElement genderCard;

    @FindBy(xpath = "//*[@id=\"widget-list-v2\"]/div[1]/div[5]/div/div[1]/div/p")
    WebElement discover;



    @FindBy(xpath = "//*[@id=\"single-search-result\"]/div/div/div/div[1]/div[1]/div")
    WebElement search;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        String url = "https://www.trendyol.com/";
        open(url);
        clickElementWhenClickable(genderCard);
    }

    public String getDiscoverText() {
        scrollToElement(discover);
        return discover.getText();

    }
    public void goToCategory() {
        int maxScroll = 5;

        for(int i = 0; i < maxScroll; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'Erkek Giyim')]/ancestor::a")));

                WebElement menClothingCategory = driver.findElement(By.xpath("//img[contains(@alt,'Erkek Giyim')]/ancestor::a"));
                clickElementWhenClickable(menClothingCategory);
                break;
            } catch (TimeoutException e) {

                WebElement nextArrow = driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/div[5]/div/div[2]/div/div/button/div"));
                nextArrow.click();
            }
        }
    }
    public String getCategoryText() {
        waitForPageLoad();
        return search.getText();
    }

//button[@data-direction="right"@data-gradient="true"]



}