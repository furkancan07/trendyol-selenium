

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
    @Test(dependsOnMethods = "test05_isThisProduct", priority = 5,description = "")
    public void test06_() {
        listPage.goToFirstProduct();
    }


}