package day14_writeExcel_screenShot_IsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.text.Utilities;
import java.io.IOException;

public class C03_tumSayfaSSMEthoduKullanma extends TestBase {
    @Test
    public void testWise() throws IOException {

        // wisequarter anasayfaya gidin
        driver.get("https://wisequarter.com");

        // url'in wise içerdiğini test edin
        String expectedUrl="wise";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        // sonucu raporlamak için screenshot alıp kayededin
        ReusableMethods.tumSayfaScreenShot(driver,"wise");
    }

    @Test
    public void testAB() throws IOException {

        // ahmetbulutluoz.com anasayfaya gidin
        driver.get("https://ahmetbulutluoz.com");
        // url'in ahmet içerdiğini test edin
        String expectedUrl="ahmet";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        // sonucu raporlamak için screenshot alıp kayededin
        ReusableMethods.tumSayfaScreenShot(driver,"ab");
    }
}
