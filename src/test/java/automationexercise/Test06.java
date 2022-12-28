package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test06 {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @After
    public void teardown() {
        // driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfaGoruntuDogrulama = driver.findElement(By.xpath("(//*[@lang='en'])[1]"));
        Assert.assertTrue(anaSayfaGoruntuDogrulama.isDisplayed());

        //4. 'Bize Ulaşın' düğmesine tıklayın
        WebElement bizeUlas = driver.findElement(By.xpath("//*[@href='/contact_us']"));
        bizeUlas.click();

        //5. "İLETİŞİME GEÇİN" ifadesinin görünür olduğunu doğrulayın
        WebElement iletisimeGec = driver.findElement(By.xpath("//*[@class='col-sm-12']"));
        Assert.assertTrue(iletisimeGec.isDisplayed());

        //6. Adı, e-postayı, konuyu ve mesajı girin
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Can", Keys.TAB,"sdada@gmail.com",Keys.TAB,"Is Basvurusu",
                Keys.TAB,"Bunyenizde Tester olarak calismak istiyorum");

        //7. Dosya yükleyin
        WebElement doysaYukle = driver.findElement(By.xpath("//*[@type='file']"));
        doysaYukle.sendKeys("C:/Users/CINAR/Downloads/araba.jpg");

        //8. 'Gönder' düğmesini tıklayın
        Thread.sleep(3000);
        WebElement gonder = driver.findElement(By.xpath("//*[@name='submit']"));
        gonder.click();

        //9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();

        //10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
        WebElement basariMesaji = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        Assert.assertTrue(basariMesaji.isDisplayed());

        //11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//*[@class='btn btn-success']"));
        anaSayfa.click();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        WebElement anaSayfaGoruntuGeldiginiDogrulama = driver.findElement(By.xpath("(//*[@lang='en'])[1]"));
        Assert.assertTrue(anaSayfaGoruntuGeldiginiDogrulama.isDisplayed());
    }
}
