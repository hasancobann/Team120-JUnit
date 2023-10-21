package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.dynalink.beans.StaticClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    // Amazon anasayfaya gidin

    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin

    /*
        Bize verilen gorevde
        olusturulacak farkli test method'lari
        ayni web sayfasinda oluyorsa
        her test method'unda yeniden driver olusturup, sonunda kapatmak yerine

        Tum @Test method'larindan once 1 kere driver olusturup
        tum @Test method'larini calistirip
        en son driver'i kapatmak daha mantikli olur.

        @Beforeclass ve @Afterclass notasyonları kullanıldığında dikkat etmemiz gerekn konu
        bu notasyonları kullanan methodların static olarak işaretlenmesinin zorunlu olmasıdır.
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
    public void titleTest() {
        String expectedIcerik = "Amazon";
        String actualIcerik = driver.getTitle();
        if (actualIcerik.contains(expectedIcerik)) {
            System.out.println("Title test passed");
        } else {
            System.out.println("Title test failed");
        }

    }

    @Test
    public void nutellaTest() {
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedIcerik="Nutella";
        String actualSonucYazisi=sonucYaziElementi.getText();

        if (actualSonucYazisi.contains(expectedIcerik)){
            System.out.println("Nutella Test passed");
        }else{
            System.out.println("Nutella test failed");
        }

    }

    @Test
    public void javaTest() {
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedIcerik="Java";
        String actualSonucYazisi=sonucYaziElementi.getText();

        if (actualSonucYazisi.contains(expectedIcerik)){
            System.out.println("Java Test passed");
        }else{
            System.out.println("Java test failed");
        }

    }


}
