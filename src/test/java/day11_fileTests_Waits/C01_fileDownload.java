package day11_fileTests_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {
    @Test
    public void indirmeTesti(){

        // /Users/hasancoban/Desktop/logo.jpg

        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // 3. logo.jpg dosyasını indirelim
        bekle(2);
        driver.findElement(By.xpath("//a[text()='logo.jpg']")).click();

        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        bekle(2);
        String dosyaYolu="/Users/hasancoban/Downloads/logo.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

//
    }
}
