package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test04 {

    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        //1. Tarayıcıyı başlatın
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() throws InterruptedException {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actualDisplay = driver.findElement(By.xpath("(//*[@lang='en'])[1]"));
        Assert.assertTrue(actualDisplay.isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement actualLoginDisplay = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(actualLoginDisplay.isDisplayed());
        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("asdzF123@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("12345", Keys.ENTER,Keys.TAB,"Login");
        //7. 'Giriş' düğmesine tıklayın
        //driver.findElement(By.xpath("//*[text()='Login']")).click();
        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement actualLogin = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(actualLogin.isDisplayed());
        //9. 'Çıkış' düğmesini tıklayın
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
        //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        Thread.sleep(2000);
        WebElement oturumAcmaSayfasi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(oturumAcmaSayfasi.isDisplayed());
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
}

