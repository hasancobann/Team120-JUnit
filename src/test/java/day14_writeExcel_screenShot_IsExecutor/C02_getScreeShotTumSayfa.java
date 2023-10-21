package day14_writeExcel_screenShot_IsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_getScreeShotTumSayfa extends TestBase {
    @Test
    public void tumSayfaScreenShot() throws IOException {
        // amazon anasayfa gidin
        driver.get("https://amazon.com");

        // Nutella için arama yapın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //Sonuçların Nutella içerdiğini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedSonuc="Nutella";
        String actualSonuc=sonucYaziElementi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        // Rapor için sayfanın fotoğrafını çekin

        TakesScreenshot tss=(TakesScreenshot) driver;

        //2.Adım==> fotoğrafı kaydedeceğimiz dosyayı oluşturup, dosya yolunun yazılması gerekir.
        File screecShot=new File("target/Screenshot/tumSayfaScreenShot.png");

        //3.Adım==>bir geçici dosya oluşturup buna tss objesi ile çektiğimiz fotoğrafı kaydedelim.
        File geciciShot=tss.getScreenshotAs(OutputType.FILE);

        //4.Adım==> Geçici resmi asıl dosyaya kopyalayalım
        FileUtils.copyFile(geciciShot,screecShot);
    }
}
