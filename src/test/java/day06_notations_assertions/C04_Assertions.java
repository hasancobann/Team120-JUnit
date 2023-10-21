package day06_notations_assertions;

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
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Assertions {
    // Amazon anasayfaya gidin

    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin

    /*
        Junit test methodları içinde yapılan testlerin
        failed ya da passed olduğunu bize raporlar.

        Ancak bu raporlama
        kodlar sorunsuz çalışıp bittiyse PASSED
        exception ile karşılaşılırsa FAİLED olarak gerçekleşir.

        Aytıca JUnit test methodları içinde yapılan testleri değil methodları raporlar.

        JUnit bu iş için Assertion class'ı oluşturmuştur.

        Bir test method'unun içinde birden fazla assertion var ise bu assetion'lardan biri FAİLED olursa
        kodun çalışması o satırda durur, geriye kalan assertion'lar kontrol edilmemiş olur.

        Eğer bir class çalıştığında tüm assertion'ların mutlaka gözden geçirilmesini istersek
        her assertion için ayrı test method'u oluşturabiliriz.

        Test methodlarının ismi de yaptığı iş ile aynı olursa konsolda neyin çalışıp neyin çalışmadığını görebiliriz.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void titleTest(){
        // 1- Title'in Amazon icerdigini test edin
        String expectedTitleIcerik ="Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Title Amazon icermiyor",actualTitle.contains(expectedTitleIcerik));
        System.out.println("Bu satir, test passed olursa calisir, failed olursa calismaz");
    }
    @Test
    public void nutellaTest(){
        // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedSonucIcerik = "Kutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));
    }
    @Test
    public void javaTest(){
        // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedSonucIcerik = "Hava";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));
    }
}
