package org.rf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage{
    @FindBy(xpath = "//span[text()='Jeans']")
    WebElement jeansCheckBox;
    @FindBy(id = "web-search-input--103")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"single-search-result\"]/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]")
    WebElement brand;
    @FindBy(xpath = "//*[@id=\"single-search-result\"]/div/div/div/div[2]/div/div[3]/div[2]/div/div[2]/div[6]/label/span[1]")
    WebElement size1;
    @FindBy(xpath = "//*[@id=\"single-search-result\"]/div/div/div/div[2]/div/div[3]/div[2]/div/div[2]/div[8]/label/span[1]")
    WebElement size2;
    @FindBy(xpath =     "//a[@data-product-index=0]")
    WebElement firstProduct;
    @FindBy(className = "web-search-result-header")
    WebElement result;
    public ProductListPage(WebDriver driver) {
        super(driver);
    }
    private void selectCategory() {
        if(!jeansCheckBox.isSelected()) {
            clickElementWhenClickable(jeansCheckBox);
        }

    }
    private void selectBrand() {
        if(!brand.isSelected()) {
            clickElementWhenClickable(brand);
        }
    }
    private void searchForArmani_Exchange() {
        searchButton.sendKeys("Armani Exchange");

    }
    private void selectSizes(){
        if(!size1.isSelected()) {
            clickElementWhenClickable(size1);
        }
        if(!size2.isSelected()) {
            clickElementWhenClickable(size2);
        }
    }
    public void ApplyFilter(){
        selectCategory();
        searchForArmani_Exchange();
        selectBrand();
        selectSizes();
    }
    public void goToFirstProduct() {
        clickElementWhenClickable(firstProduct);
    }
    public String getResultText(){
        waitForPageLoad();
        return result.getText();
    }

}
