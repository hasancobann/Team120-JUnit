package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookieTesti(){
       // 1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
       // 2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet= driver.manage().getCookies();

       // System.out.println(cookieSet); ==> Bu şekilde yazdırınca kaç tane olduğu ve me olduğu anlaşılmaz

        int siraNo=1;
        for (Cookie each:cookieSet
             ) {
            System.out.println(siraNo+"  -  "+each);
            siraNo++;
        }

       // 3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCokiesSAyisi=5;
        int actualCookiesSayisi=cookieSet.size();
        Assert.assertTrue(actualCookiesSayisi>expectedCokiesSAyisi);
       // 4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieValue="USD";
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);
       // 5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie newCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);

       // 6- eklediginiz cookie’nin sayfaya eklendigini test edin
        System.out.println("_________________");
        cookieSet= driver.manage().getCookies();
        siraNo=1;
        for (Cookie each:cookieSet
        ) {
            System.out.println(siraNo+"  -  "+each);
            siraNo++;
        }
        boolean yeniCookieEklendiMi=false;  // flag ile testimizi yapıyoruz
        for (Cookie each:cookieSet
             ) {
            if (each.getName().equals("en sevdigim cookie")){
                yeniCookieEklendiMi=true;
            }
        }
        // cookie eklendiyse yeniCookieEklendiMi değeri true olur.
        Assert.assertTrue(yeniCookieEklendiMi);

       // 7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        System.out.println("_________________");
        cookieSet= driver.manage().getCookies();
        siraNo=1;
        for (Cookie each:cookieSet
        ) {
            System.out.println(siraNo+"  -  "+each);
            siraNo++;
        }
        boolean skinSilindiMi=true;
        for (Cookie each:cookieSet
        ) {
            if (each.getName().equals("skin")){
                skinSilindiMi=false;
            }
        }// testin passed olması için boolean değerinin true olması lazım
        Assert.assertTrue(skinSilindiMi);

       // 8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookieSet= driver.manage().getCookies();
        int expectedSetSize=0;
        int actualSetSize=cookieSet.size();
        Assert.assertEquals(expectedSetSize,actualSetSize);

        driver.close();
    }
}
