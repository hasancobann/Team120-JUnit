package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_KontrolsuzCokluWindow extends TestBase {
    @Test
    public void cokluPencereTesti() {

//https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkWHAndleDegeri = driver.getWindowHandle();
//Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textElement = driver.findElement(By.tagName("h3"));
        String expectedText = "Opening a new window";
        String actualText = textElement.getText();
        Assert.assertEquals(expectedText, actualText);
//Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
//Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
//Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        /*
        Bir linke tıkladığımızda biz new window kullanmadığımız halde yeni sayfa açılıyorsa
        driver eski sayfada kalır. Yeni sayfada işlem yapabilmek için yendriver'ın o sayfya geçmesi gerekir.
         */
        Set<String> whdSeti = driver.getWindowHandles();
        System.out.println("İlk sayfa handle değeri: " + ilkWHAndleDegeri);
        System.out.println("window handle seti: " + whdSeti);

        String ikinciSayfaWhd ="";

        for (String each : whdSeti
        ) {
            if (!each.equals(ilkWHAndleDegeri)) {
                 ikinciSayfaWhd = each;
            }
        }

        // artık 2. sayfanın window handle değerini bildiğimiz için o sayfaya geçiş yapabiliriz.
        driver.switchTo().window(ikinciSayfaWhd);

        String expectedTitle2 = "New Window";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);

//Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement actualText2= driver.findElement(By.tagName("h3"));
        String expectedText2 ="New Window";
        String actualText3=actualText2.getText();
        Assert.assertEquals(expectedText2,actualText3);
//Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkWHAndleDegeri);
        String expectedTitle3 = "The Internet";
        String actualTitle3 = driver.getTitle();
        Assert.assertEquals(expectedTitle3, actualTitle3);
    }
}
