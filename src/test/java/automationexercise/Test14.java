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

import java.time.Duration;

public class Test14 {

    WebDriver driver;
    @Before
    public void setUp(){

        //1. Launch browser

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void test(){

        //2. Navigate to url 'http://automationexercise.com' --2. 'http://automationexercise.com' URL'sine gidin
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully --3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anasayfa =driver.findElement(By.xpath("//*[@aria-hidden='false']"));
        Assert.assertTrue(anasayfa.isDisplayed());

        //4. Add products to cart --4. Sepete ürün ekleyin
        driver.findElement(By.xpath("//*[@data-product-id='23']")).click();
        WebElement continueShopping = driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        continueShopping.click();

        //5. Click 'Cart' button --5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/view_cart']")).click();

        //6. Verify that cart page is displayed --6. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement sepetSayfası= driver.findElement(By.cssSelector("div[id='cart_info']"));
        Assert.assertTrue(sepetSayfası.isDisplayed());

        //7. Click Proceed To Checkout --7. Ödeme İşlemine Devam Et'i tıklayın
        WebElement odemeİslemiDevamEt = driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));
        odemeİslemiDevamEt.click();

        //8. Click 'Register / Login' button --8. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

        //9. Fill all details in Signup and create account --9. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Afra", Keys.TAB,"asdfghj@gmail.com",Keys.TAB,Keys.ENTER);

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //11. Verify ' Logged in as username' at top
        //12.Click 'Cart' button
        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button


    }
}
