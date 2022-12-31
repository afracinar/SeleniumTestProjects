package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Test13 {

    WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @Test
    public void test() throws InterruptedException {

        //1. Launch browser --1. Tarayıcıyı başlatın

        //2. Navigate to url 'http://automationexercise.com' --2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully  --3.Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anasayfa =driver.findElement(By.xpath("//*[@aria-hidden='false']"));
        Assert.assertTrue(anasayfa.isDisplayed());
        driver.navigate().refresh();

        //4. Click 'View Product' for any product on home page --4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("//*[@href='/product_details/39']")).click();


        //5. Verify product detail is opened --5. Ürün detayının açıldığını doğrulayın
        WebElement urunDetay = driver.findElement(By.cssSelector("div[class='product-information']"));
        Assert.assertTrue(urunDetay.isDisplayed());

        //6. Increase quantity to 4 --6. Miktarı 4'e yükseltin
        WebElement urunMiktar = driver.findElement(By.cssSelector("input[id='quantity']"));
        urunMiktar.sendKeys(Keys.ARROW_RIGHT,Keys.BACK_SPACE);
        Thread.sleep(2000);
        urunMiktar.sendKeys("4");

        //7. Click 'Add to cart' button --7. 'Sepete ekle' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@type='button']")).click();

        //8. Click 'View Cart' button --8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //9. Verify that product is displayed in cart page with exact quantity --9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
        WebElement miktarKontrol = driver.findElement(By.cssSelector("button[class='disabled']"));
        String ss = miktarKontrol.getText();
        int ssint =Integer.parseInt(ss);
        Assert.assertEquals(ssint,4);

    }
}
