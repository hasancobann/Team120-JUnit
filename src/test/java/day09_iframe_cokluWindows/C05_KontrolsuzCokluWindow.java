package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C05_KontrolsuzCokluWindow extends TestBase {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe url'ine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkHandleDegeri = driver.getWindowHandle();

        // sayfa basliginin Internet icerdigini test edin
        String expectedTitleIcerik = "Internet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Elemental Selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // Yeni acilan tab'in Title'inin Selenium icerdigini test edin
        String ikinciHandleDegeri = "";
        Set<String> whdSeti = driver.getWindowHandles();
        for (String each : whdSeti
        ) {
            if (!each.equals(ilkHandleDegeri)) {
                ikinciHandleDegeri = each;
            }
        }
        driver.switchTo().window(ikinciHandleDegeri);
        String expectedTitleIcerik2 = "Selenium";
        String actualTitle2 = driver.getTitle();
        Assert.assertTrue(actualTitle2.contains(expectedTitleIcerik2));

        // Ilk sayfaya donup url'in internet icerdigini test edin
        driver.switchTo().window(ilkHandleDegeri);
        String expectedUrlIcerik = "internet";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }
}
