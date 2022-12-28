package automationexercise;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2. 'http://automationexercise.com/' URL'sine gidin
        driver.get("https://automationexercise.com/");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement anaSayfa = driver.findElement(By.cssSelector("html[lang='en']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("a[href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür.
        WebElement yeniKulKay=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (yeniKulKay.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //6. Adı ve e-posta adresini girin
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Can", Keys.ENTER);
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("sdada@gmail.com", Keys.ENTER);

        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//form[@action='/signup']")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın.
        WebElement hesapBilGir = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (hesapBilGir.isDisplayed()){
            System.out.println("Hesap Bilgilerini Gir testi PASSED");
        }else System.out.println("Hesap Bilgilerini Gir testi FAILED");

        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi.
        driver.findElement(By.cssSelector("input[type='radio']")).click();
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("12345",Keys.TAB,"26",Keys.TAB,"December",Keys.TAB,"2021");

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.cssSelector("input[id='newsletter']")).click();

        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.cssSelector("input[id='optin']")).click();

        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası.
        driver.findElement(By.cssSelector("input[id='first_name']")).sendKeys("Can", Keys.TAB,"Akdemir",Keys.TAB,"TechPro",Keys.TAB,"İzmir",Keys.TAB,"Menemen");
        driver.findElement(By.cssSelector("select[id='country']")).sendKeys("Canada",Keys.TAB,"Ege",Keys.TAB,"İzmir",Keys.TAB,"35",Keys.TAB,"055555");
        //13. 'Hesap Oluştur düğmesini' tıklayın.
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür.
        WebElement görünürMü= driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (görünürMü.isDisplayed()){
            System.out.println("Yazı görünür.test passed");
        }else System.out.println("Yazı görünmüyor test failed");

        //15. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//[@class='btn btn-primary']")).click();

        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement kullaniciAdigorunurMu = driver.findElement(By.xpath("//[@class='fa fa-user']"));
        if (kullaniciAdigorunurMu.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
        WebElement hesapSilindiMi = driver.findElement(By.xpath("//[text()='Account Deleted!']"));
        if (hesapSilindiMi.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.findElement(By.xpath("//[@data-qa='continue-button']")).click();



    }
}

