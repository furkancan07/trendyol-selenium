

import org.testng.Assert;
import org.testng.annotations.Test;

public class TrendyolFlowTest extends BaseTest {

    @Test(priority = 0, description = "Adım 1 - Trendyol Ana sayfası başarıyla açılması")
    public void test01_openHomePage() {
        homePage.openHomePage();
    }

    @Test(priority = 1, description = "Adım 2 - Katogorilerdeki indirimleri keşfeti bulma")
    public void test02_discoverText() {
        Assert.assertEquals(homePage.getDiscoverText(),"Kategorilerdeki İndirimleri Keşfet");
    }

    @Test(priority = 2, description = "Adım 2 - Katogorilerdeki indirimleri keşfeti bulma")
    public void test03_successOpenCategoryPage() {
        homePage.goToCategory();
        Assert.assertTrue(homePage.getCategoryText().contains("Erkek Giyim"));

    }
    @Test(priority = 3,description = "Adım 3 - Filterları uygulama")
    public void test04_ApplyFilter() {
        listPage.ApplyFilter();
    }
    @Test(priority = 4,description = "Adim 4 - Ürün Bulunamadı")
    public void test05_isThisProduct() {
        String text=listPage.getResultText();
        String expected="Armani";
        Assert.assertTrue(text.contains(expected));
    }
    @Test(priority = 5,description = "")
    public void test06_() {
        listPage.goToFirstProduct();
    }
    @Test(priority = 6,description = "Ürün Bilgilerini Alma")
    public void test07_findProductInformation() {
        productPage.test07();
    }
    @Test(priority = 7,description = "Pdf Oluşturma")
    public void test08_pdfGenerate() {
        productPage.pdfGenerate();
    }
    @Test(priority = 8,description = "Email Gönderme")
    public void test09_sentToEmail() {
        productPage.sendEmail();
    }
    @Test(priority = 9,description = "Sepete Ekleme")
    public void test10_addCart() {
        productPage.addCart();
    }
    @Test(priority = 10,description = "Sepet Sayfasına gitme")
    public void test11_goToCartPage() {
        productPage.goToCartPage();

    }
    @Test(priority = 11,description = "Ürün Sayısını Arttırma")
    public void test12_increaseProductCount() {
       cartPage.increaseProductCount();
       Assert.assertEquals(cartPage.getCartCount(),"3");
    }
    @Test(priority = 12,description = "Ürünü Sepetten Silme")
    public void test13_deleteProductFromCart() {
        cartPage.deleteProductFromCart();
        Assert.assertTrue(cartPage.getRemovedItem().contains("ürünü sepetinden kaldırıldı."));
    }




}