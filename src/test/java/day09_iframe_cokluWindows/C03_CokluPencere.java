package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_CokluPencere extends TestBase {

    @Test
    public void Test01(){
        // amazon ana sayfaya gidip url'in amazon icerdigini test edin
        driver.get("https://amazon.com");
        String expectedUrlIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        String amazonWindowHandleDegeri=driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");
        expectedUrlIcerik="wise";
        actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        String wiseWindowHandleDegeri=driver.getWindowHandle(); // ilerleyen görevlerde bu sayfaya geri dönmemiz gerekirse
        // bu sayfların window handle değerini almamız gerekir.

        // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://youtube.com");
        expectedUrlIcerik="youtube";
        actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
        driver.switchTo().window(wiseWindowHandleDegeri);
        String expectedTittleIcerik="Wise";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTittleIcerik));
        // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonWindowHandleDegeri);
        expectedTittleIcerik="Amazon";
        actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTittleIcerik));

    }
}
