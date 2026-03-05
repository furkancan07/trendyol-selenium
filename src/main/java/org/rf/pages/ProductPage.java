package org.rf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.rf.utils.Product;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"widget-list-v2\"]/div[1]/div[5]/div/div[2]/div/div/button/div")
    WebElement title;
    @FindBy(xpath = "/html/body/main/div/div[2]/div[1]/div/div[2]/section[2]/div[2]/div/div/div[1]/a")
    WebElement username;
    @FindBy(xpath = "/html/body/main/div/div[2]/div[1]/div/div[2]/section[1]/div[4]/div/div[1]/span/span")
    WebElement size;
    @FindBy(xpath = "/html/body/div[3]/div/div[1]/div/div[1]/div/div/div[2]/div[2]")
    WebElement price;
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    /*private String getTitle() {
        return title.getText();
    }
    private String getUsername() {
        return username.getText();
    }
    private String getSize() {
        return size.getText();
    }
    private String getPrice() {
        return price.getText();
    }*/

    public Product findProductInfo(){
        return null;
    }

    private String getAllProductFeatures() {
        StringBuilder allText = new StringBuilder();

        try {
            List<WebElement> featuredItems = driver.findElements(By.cssSelector(
                    "ul.content-descriptions-description-content li"
            ));

            for (WebElement item : featuredItems) {
                allText.append(item.getText().trim()).append("\n");
            }

            List<WebElement> productAttributes = driver.findElements(By.cssSelector(
                    "div.attribute-item"
            ));

            for (WebElement attr : productAttributes) {
                String name = attr.findElement(By.cssSelector("div.name")).getText().trim();
                String value = attr.findElement(By.cssSelector("div.value")).getText().trim();
                allText.append(name).append(": ").append(value).append("\n");
            }

        } catch (Exception e) {
            System.out.println("Özellikler alınırken hata: " + e.getMessage());
        }

        return allText.toString();
    }

}
