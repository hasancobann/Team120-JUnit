package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MoveToElements extends TestBase {

    @Test
    public void test01(){

        /*
        Bazı html kodlar mouse ile yaklaştığımızda aktif hale gelir.
        Amazon anasayfa'daki acoun&list menüsü de mouse ile yaklaşınca açılıyor.
        Mouse ile yaklaşmasak da menü üzerindeki linklere ait html kodlar görünüyor fakat kullanılamıyor.
        Açılır menüyü açmadan elementleri kullanmaya kalkışırsak ElementNotInteractableException verir.
         */
       // 1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
       // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement target= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        actions.moveToElement(target).perform();
       // 3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
       // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourList= driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourList.isDisplayed());

    }
}
