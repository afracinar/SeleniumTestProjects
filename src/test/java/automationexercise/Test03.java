package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test03 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter incorrect email address and password
    //7. Click 'login' button
    //8. Verify error 'Your email or password is incorrect!' is visible
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com"); //2
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test01(){
        //3  Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        //4 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5 "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement loggedYazisi = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loggedYazisi.isDisplayed());

        //6 Yanlış e-posta adresi ve şifre girin
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("team12@gma.com");
        WebElement pwd = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        pwd.sendKeys("123");

        //7 'Giriş' düğmesine tıklayın
        WebElement loginButton = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
        loginButton.click();

        //8 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        WebElement yanlisYazisi = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(yanlisYazisi.isDisplayed());
    }
}





//1. Tarayıcıyı başlatın
//2. 'http://automationexercise.com' URL'sine gidin
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
//4. 'Kaydol / Giriş Yap' düğmesine tıklayın
//5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
//6. Yanlış e-posta adresi ve şifre girin
//7. 'Giriş' düğmesine tıklayın
//8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür

