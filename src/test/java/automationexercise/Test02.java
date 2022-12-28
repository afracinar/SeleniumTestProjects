package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {
        /*
    1. Tarayıcıyı başlat
2. URL'ye git 'http://automationexercise.com '
3. Giriş sayfasının başarıyla görüntülendiğini doğrulayın
4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
5. 'Hesabınıza giriş yap' seçeneğinin görünür olduğunu doğrulayın
6. Doğru e-posta adresini ve şifreyi girin
7. 'Giriş yap' düğmesini tıklayın
8. 'Kullanıcı adı olarak oturum açtınız' seçeneğinin görünür olduğunu doğrulayın
9. 'Hesabı Sil' düğmesini tıklayın
10. HESABIN silindiğini doğrulayın!' görünür
*/
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. 'http://automationexercise.com/' URL'sine gidin
        driver.get("https://automationexercise.com/");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.cssSelector("html[lang='en']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("PASSED");
        } else System.out.println("FAILED");

        // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. 'Hesabınıza giriş yap' seçeneğinin görünür olduğunu doğrulayın
        WebElement hesabinizaGrsGorunurMu= driver.findElement(By.xpath("//*[@class='login-form']"));
        if (hesabinizaGrsGorunurMu.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//*[@type='email'][1]")).sendKeys("meryemkkkk@gmail.com", Keys.TAB,"1234567");

        // 7. 'Giriş yap' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        //8. 'Kullanıcı adı olarak oturum açtınız' seçeneğinin görünür olduğunu doğrulayın
        WebElement loggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        if (loggedInAs.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        // 9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //10. HESABIN silindiğini doğrulayın!' görünür
        WebElement hesapSilindiMi = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        if (hesapSilindiMi.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");
    }
}
