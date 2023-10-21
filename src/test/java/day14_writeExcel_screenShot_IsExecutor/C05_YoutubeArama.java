package day14_writeExcel_screenShot_IsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_YoutubeArama extends TestBase {
    @Test
    public void youtubeAramaTesti() throws IOException {
        // youtube ana sayfaya gidin
        driver.get("https://youtube.com");
        // ahmet bulutluöz için arama yapın
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='search']"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("Ahmet bulutluoz"+ Keys.ENTER);
        bekle(5);
        //bulunan videolardan ilkinin isminde bulut geçtiğini test edin
        WebElement ilkVideoIsim= driver.findElement(By.xpath("(//a[@id=‘video-title’])[1]"));
        String expectedIcerik="Bulut";
        String actualVideoIsmi=ilkVideoIsim.getText();
        Assert.assertTrue(actualVideoIsmi.contains(expectedIcerik));
        // ilk videonun fotoğrafını çekin
        File sonucYazisiSS = new File("target/screenShots/sonucYazisi.jpg");

        File geciciResim=ilkVideoIsim.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,sonucYazisiSS);
        ReusableMethods.webElementFotografCek(ilkVideoIsim,"NutellaArama");
    }
    }

