package day14_writeExcel_screenShot_IsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_webElementScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {

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

        // Rapora eklemek için sonuç yazısının screenshot'ını alalım
        File sonucYazisiSS=new File("target/Screenshot/sonucYazisi.jpeg");
        File geciciResim=sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,sonucYazisiSS);

    }
}
