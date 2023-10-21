package day11_fileTests_Waits;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DinamikDosyaYoluOlusturma {
    @Test
    public void test001() {

        /*
        Testlerimizin farklı bilgisayarlarda da çalışması gerekiyorsa
        file testleri için gerekli olan dosya yolu dinamik hale getirilmelidir.

        Java da dosya yolunu kodun çalıştığı bilgisayardan otomatik olarak almak için 2 seçenek vardır.
        1- System.getProperty("user.home") ==> bilgisayarın ana dosya yolunu verir
        System.getProperty("user.dir") ==>
         */
        // Masaüstümüzde bulunan logo.jpg dosyanın varlığını dinamik doya yolu kullanarak test edelim.

        // /Users/hasancoban/Desktop/logo.jpg

        // "/Users/hasancoban"   +             "/Desktop/logo.jpg"
        //    Ana dosya yolu        +    Her bilgisayarda aynı olan kısım

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpg";
        System.out.println(dinamikDosyaYolu);

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        System.out.println(System.getProperty("user.dir"));

        // projemizde var olan text.txt'nin varlığını dinamik dosya yolu ile test edelim
        ///Users/hasancoban/IdeaProjects/Team120_JUnit_Fall2023    /src/test/java/day11_fileTests_Waits/text.txt

        String dinamikTextDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day11_fileTests_Waits/text.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyaYolu)));

    }
}
