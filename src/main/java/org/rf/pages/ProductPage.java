package org.rf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rf.utils.MailUtil;
import org.rf.utils.PdfUtil;
import org.rf.utils.Product;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1[@data-testid='product-title']")
    WebElement title;
    @FindBy(css = "a.product-title-brand-name-anchor")
    WebElement username;

    @FindBy(css = "span.discounted")
    WebElement price;

    @FindBy(css = "span.selected-variant")
    WebElement size;
    @FindBy(className = "onboarding__default-renderer-primary-button")
    WebElement acceptButton;
    @FindBy(className = "basket-wrapper-link")
    WebElement cartButton;
    @FindBy(className = "add-to-cart-button-text")
    WebElement addToCartButton;

    Product product;
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
   public void test07() {
       switchToNewTab();
       clickElementWhenClickable(acceptButton);
       product=findProductInfo();
       System.out.println(product.toString());
       waitThreeSeconds();
   }
   public void pdfGenerate() {
       PdfUtil.createProductPdf(product,"output/product.pdf");
   }
    private Product findProductInfo(){
        waitForPageLoad();
        return Product.builder().
                title(title.getText()).
                username(username.getText()).
                size(size.getText()).
                price(price.getText()).
                information(getAllProductFeatures()).
                build();
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

    public void addCart() {
       clickElementWhenClickable(addToCartButton);
       waitThreeSeconds();
    }

    public void sendEmail() {
        MailUtil.sendPdfMail("output/product.pdf");
        waitThreeSeconds();
    }

    public void goToCartPage() {
       clickElementWhenClickable(cartButton);

    }
}
