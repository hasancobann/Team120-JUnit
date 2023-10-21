package day11_fileTests_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01(){
        // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // 2.chooseFile butonuna basalim
        // 3.Yuklemek istediginiz dosyayi secelim.
        /*
        insan olarak dosya seçimi için chooseFile butonuna bastıktan sonra acılan pencereden istediğimiz dosyayı seçip yükleriz.
        Selenium da otomasyon ile bu işlemi yapmak için chooseFile butonu locate edilip, bu Webelement'e
        sendKeys(yüklenecek dosyanın dosya yolu); yapılır.

        /Users/hasancoban/IdeaProjects/Team120_JUnit_Fall2023   /src/test/java/day11_fileTests_Waits/text.txt
         */
        WebElement uploadButonElementi = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day11_fileTests_Waits/text.txt";

        uploadButonElementi.sendKeys(dinamikDosyaYolu);
        bekle(5);
        // 4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        // 5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());
    }
}
