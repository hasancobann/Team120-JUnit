package day14_writeExcel_screenShot_IsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JsExecutor extends TestBase {
    @Test
    public void test01(){
        // wise anasayfaya gidin
        driver.get("https://wisequarter.com");
        //wisequarter anasayfasina gidin alt kisimda bulunan “Go To Career Page” butonuna kadar asagi inin ve bu butona click yapin
        WebElement goToCareerElementi= driver.findElement(By.xpath("(//*[@href='https://wisequarter.com/career/'])[10]"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",goToCareerElementi);
        bekle(3);
        jse.executeScript("alert('yaşasıın');");
        bekle(3);

    }
}
