package org.rf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(className = "remove-item-container")
    WebElement deleteCartButton;
    @FindBy(xpath = "//button[@data-testid=\"quantity-button-increment\"]")
    WebElement increaseButton;
    @FindBy(xpath = "//input[@data-testid=\"quantity-selector\"]")
    WebElement quantity;
    @FindBy(className = "removed-item-text")
    WebElement removedItem;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteProductFromCart() {
        clickElementWhenClickable(deleteCartButton);
    }
    public String getCartCount(){
        return quantity.getText();
    }
    public String getRemovedItem(){
        return removedItem.getText();
    }

    public void increaseProductCount() {
        clickElementWhenClickable(increaseButton);
        clickElementWhenClickable(increaseButton);

    }
}
