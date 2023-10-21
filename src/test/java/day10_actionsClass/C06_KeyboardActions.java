package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test01(){
        // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(3);

        // 4- videoyu izlemek icin Play tusuna basin
        WebElement iframe= driver.findElement(By.xpath("//*[@*='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement playTusu= driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        playTusu.click();
        bekle(3);
        // 5- videoyu calistirdiginizi test edin
        WebElement youtube= driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue(youtube.isDisplayed());
    }

}
