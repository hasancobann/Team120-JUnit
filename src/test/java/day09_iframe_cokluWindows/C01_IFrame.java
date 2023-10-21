package day09_iframe_cokluWindows;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void test01(){
        //    1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

//            2 ) Bir metod olusturun: iframeTest
// - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iFrameYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iFrameYaziElementi.isEnabled());
//            - Text Box’a “Merhaba Dunya!” yazin.
        /*
        Locate doğru olduğu halde webelementi kullanamıyorsak webelement bir iframe olabilir.
        Eğer iframe içindeyse
        -önce iframe locate etmeli
        -locate ettiğimiz iframe geçiş yapılmalı
        -sonra istenen islemi gerceklestirmeliyiz

        Iframe'e gecis yapinca
        driver'imiz artik o sayfaya gecmis olur
        anasayfadaki webelementleri goremez
        Eger testimizde iframe disindan element kullanmamiz gerekirse
        once iframe'den disari cikmamiz lazim
         */
        WebElement iframe= driver.findElement(By.xpath("//*[@id='mce_0_ifr']")); // iframe'i locate ettik
        driver.switchTo().frame(iframe); // iframe'e geçiş yaptık

        WebElement textBox= driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya!");

// - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent(); // iframe içine girmiştik bununla ana sayfamıza geri geldik
        //driver.switchTo().parentFrame(); ==> parentFrame() bir üst sayfaya çıkar, defaultContent() en üstteki sayfaya döner.
        WebElement elementalLink= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalLink.isDisplayed());
        System.out.println(elementalLink.getText());


    }

}
