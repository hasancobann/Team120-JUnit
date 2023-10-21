package day07_assertions_checkBox;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_DropDownMenu extends TestBase {

    @Test
    public void test01(){
         driver.get("https://amazon.com");
        // 1. Adım == dropdown webelementi locate et
        WebElement dropdownElementi= driver.findElement(By.xpath("//select[@title='Search in']"));


        // 2.adım == locate ettiğimiz webelementi parametre olarak yazip select objesi oluştur
        Select select=new Select(dropdownElementi);

        // 3. adım == select objesi ile istenen işlemi yap
        select.selectByIndex(7);
        bekle(2);
        select.selectByValue("search-alias=arts-crafts-intl-ship");
        bekle(2);
        select.selectByVisibleText("Books");
        bekle(2);
    }
}
