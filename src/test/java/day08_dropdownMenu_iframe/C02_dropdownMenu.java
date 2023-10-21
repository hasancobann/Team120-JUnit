package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C02_dropdownMenu extends TestBase_BeforeClass { // 2 test olduğu için before class kullandık

    WebElement categoryDropdownElementi;
    Select select;
    @Before
    public void amazonaGidis(){
        driver.get("https://www.amazon.com.tr/ ");
        driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]")).click();
       categoryDropdownElementi= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(categoryDropdownElementi);
    }

    @Test
    public void dropdownTest(){
        // https://www.amazon.com/ adresine gidin.
        //         - Test 1
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        List<WebElement> optionsList=select.getOptions();

        int expectedCategorySayi=45;
        int actualcategoryList=optionsList.size();

        Assert.assertEquals("Category dropdown menüsünde 45 option yok. ",expectedCategorySayi,actualcategoryList);



    }
    @Test
    public void javaAramaTest(){
        //         -Test 2
        // 1. Kategori menusunden Books secenegini secin 2. Arama kutusuna Java yazin ve aratin
        select.selectByVisibleText("Kitaplar");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        // 3. Bulunan sonuc sayisini yazdirin
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonucElementi.getText());
        // 4. Sonucun Java kelimesini icerdigini test edin
        String expectedSonucIcerik="Java";
        String  actualSonucYazisi=aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    }
}
