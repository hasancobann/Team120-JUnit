package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_BeforeAfterNotations {

    /*
    bir class'ın içinde her test method'undan önce çalışmasını istediğimiz
    sıradan bir method var ise o method'un başına @Before kullanırsak
    @Test methodlarında ÇAĞIRMAYA GEREK OLMADAN
    o method her test method'undan önce çalışır.

    Aynı şekilde her test method'undan sonra çalışmasını istediğimiz sıradan bir
    method var ise @After notasyonu ile işaretleyebiliriz.

     */


    // 1 - Amazon anasayfya gidip, url'in amazon içerdiğini test edin ve sayfayı kapatın.
    // 2 - Wisequarter anasayfya gidip, title'in Wise içerdiğini test edin ve sayfayı kapatın.
    // 3 - Youtube anasayfya gidip, title'in best içermediğini test edin ve sayfayı kapatın.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        ReusableMethods.bekle(2);
        driver.close();
    }

    @Test
    public void amazonTest(){
        // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin

        driver.get("https://www.amazon.com");
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon testi PASSED");
        }else{
            System.out.println("Amazon testi FAILED");
        }

    }

    @Test
    public void wiseTesti(){
        // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin

        driver.get("https://www.wisequarter.com");
        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else{
            System.out.println("Wisequarter testi FAILED");
        }

    }

    @Test
    public void youtubeTesti(){
        // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin

        driver.get("https://www.youtube.com");
        String unexpectedTitleIcerik = "best";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(unexpectedTitleIcerik)){
            System.out.println("Youtube testi FAILED");
        }else{
            System.out.println("Youtube testi PASSED");
        }

    }
}
