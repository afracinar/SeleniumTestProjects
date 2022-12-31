package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test08 {

    @Test
    public void test08()throws InterruptedException  {
//1. Tarayıcıyı başlatın

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

        //  3. Giriş sayfasının başarıyla göründüğünü doğrulayın
        WebElement logo = driver.findElement(By.xpath("//*[@aria-hidden='false']"));
        Assert.assertTrue(logo.isDisplayed());


        //4. 'Ürünler' düğmesine tıklayın
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@href='/products']")).click();

        //5. Kullanıcının TÜM ÜRÜNLER(all product) sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement allProductSayfasinaYonlendir = driver.findElement(By.cssSelector("div[class='features_items']"));
        Assert.assertTrue(allProductSayfasinaYonlendir.isEnabled());

//6. Ürün listesi(product list) görünür
        Thread.sleep(3000);
        WebElement allProducts= driver.findElement(By.xpath("//*[text()='All Products']"));
        allProducts.isDisplayed();

//7. İlk ürünün(first product) 'Ürünü Görüntüle(view product)'ye tıklayın
         WebElement viewProduct = driver.findElement(By.xpath("//*[@href='/product_details/1']"));
         viewProduct.click();


//8. Kullanıcı ürün detay sayfasına(product detail page) yönlendirilir(kullanici urun detay sayfasina yonlendirilir
        Thread.sleep(3000);
        WebElement urunDetaySayfasi = driver.findElement(By.xpath("//*[@class='col-sm-7']"));
        Assert.assertTrue(urunDetaySayfasi.isDisplayed());


//9. Ayrıntı ayrıntılarının görünür olduğunu doğrulayın: ürün adı(product name), kategori, fiyat(price),
// stok durumu(availablity), durum(condition), marka(brand)
        Thread.sleep(3000);
        WebElement productName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());

        WebElement kategori= driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        Assert.assertTrue(kategori.isDisplayed());


        WebElement fiyat = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Assert.assertTrue(fiyat.isDisplayed());

        WebElement stokDurumu = driver.findElement(By.xpath("//*[text()='Availability:']"));
        Assert.assertTrue(stokDurumu.isDisplayed());

        WebElement durum = driver.findElement(By.xpath("//*[text()='Condition:']"));
        Assert.assertTrue(durum.isDisplayed());

        WebElement marka = driver.findElement(By.xpath("//*[text()='Brand:']"));
        Assert.assertTrue(marka.isDisplayed());


//10.Sayfayi kapatiniz
        Thread.sleep(3000);
        driver.close();
    }

}

// 1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Products' button
//5. Verify user is navigated to ALL PRODUCTS page successfully
//6. The products list is visible
//7. Click on 'View Product' of first product
//8. User is landed to product detail page
//9. Verify that  detail is visible: product name, category, price, availability, condition, brand//

