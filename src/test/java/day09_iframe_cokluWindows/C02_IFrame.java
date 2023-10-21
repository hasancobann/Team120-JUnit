package day09_iframe_cokluWindows;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_IFrame extends TestBase {

    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        //   cikarsa cookies kabul edin
        driver.get("http://demo.guru99.com/test/guru99home/");

        // cookies çıkması durumunda aşağıdaki kodlar yazılır:
        //WebElement cookiesIFrame = driver.findElement(By.id("gdpr-consent-notice")); ==> iframe locate
        //driver.switchTo().frame(cookiesIFrame); ==> iframe'e geçiş yaptık
       // driver.findElement(By.xpath("//*[text()='Accept All']")).click(); ==> cookies'i kabul ettik

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi : " + iframeList.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeIframe= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeIframe);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //   (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement guruIframeElementi= driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(guruIframeElementi);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        bekle(3);
    }
}
