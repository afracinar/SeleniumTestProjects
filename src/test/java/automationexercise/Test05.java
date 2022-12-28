package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test05 {

    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
    //6. Adı ve kayıtlı e-posta adresini girin
    //7. 'Kaydol' düğmesini tıklayın
    //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür

    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        //1. Tarayıcıyı başlatın
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

        @Test
            public void test() {
            //2. 'http://automationexercise.com' URL'sine gidin
            driver.get("https://automationexercise.com");

            //3. Ana sayfanın başarıyla göründüğünü doğrulayın
            WebElement actualDisplay = driver.findElement(By.xpath("(//*[@lang='en'])[1]"));
            Assert.assertTrue(actualDisplay.isDisplayed());

            //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
            driver.findElement(By.xpath("//*[@href='/login']")).click();

            //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement yeniKulGör = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(yeniKulGör.isDisplayed());

            //6. Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("afra", Keys.TAB,"asdzF123@gmail.com");

            //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.cssSelector("button[type='submit']")).click();

            //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür
        WebElement epostaKayıtlı = driver.findElement(By.cssSelector("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(epostaKayıtlı.isDisplayed());




        }

    }


