package task02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Task02 {
        /*
        -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    -Before methodunda http://www.google.com adresine gidin
    -Üç farklı test methodu ile;
    -arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    -arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    -arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    -NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
    -AfterClass ile kapatın
         */
        WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");
    }



    @Test
    public void test01() throws InterruptedException {
        WebElement aramakutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramakutusu.sendKeys("The God Father");
        aramakutusu.submit();

        WebElement sonucyazisi=driver.findElement(By.id("result-stats"));
        String sonucyazisi01=sonucyazisi.getText();
        System.out.println("The God Father Sonuc= " + sonucyazisi01);


    }
    @Test
    public void test02() throws InterruptedException {
        WebElement aramakutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramakutusu.sendKeys("Lord of The Rings");
        aramakutusu.submit();

        WebElement lordSonuc=driver.findElement(By.id("result-stats"));
        String lordSonuc01=lordSonuc.getText();
        System.out.println("Lord of The Rings  = "  +lordSonuc01);

    }
    @Test
    public void aramakutusukilbill() {
        WebElement aramakutusukilbill01 = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramakutusukilbill01.sendKeys("Kill Bill");
        aramakutusukilbill01.submit();


        WebElement kilbillSonuc = driver.findElement(By.id("result-stats"));
        String killbillSonuc01 = kilbillSonuc.getText();
        System.out.println("kil bill sonuc= " + killbillSonuc01);

    }

}
