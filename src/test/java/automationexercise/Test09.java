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

public class Test09 {

    WebDriver driver;
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //   1. Launch browser
        driver.get("http://automationexercise.com");
    }
    //2. Navigate to url 'http://automationexercise.com'
    @Test
    public void test1() throws InterruptedException {
        //   3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        // driver.switchTo().alert().dismiss();
        //4. Click on 'Products' button
        driver.navigate().to("https://automationexercise.com/products");
        WebElement products = driver.findElement(By.xpath("//*[@href='/products']"));
        products.click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//div[@style='height: auto !important;']"));
        Assert.assertTrue(allProducts.isEnabled());
        //6. Enter product name in search input and click search button
        WebElement searchProduct = driver.findElement(By.xpath("//input[@id='search_product']"));
        searchProduct.sendKeys("POLO");
        WebElement button = driver.findElement(By.xpath("//*[@type='button']"));
        button.click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProduct = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(searchedProduct.isDisplayed());
        //8. Verify all the products related to search are visible
        WebElement searchedAllProducts = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(searchedAllProducts.isDisplayed());
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
