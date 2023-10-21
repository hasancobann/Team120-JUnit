package day13_excelOtomasyonu;

import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {
    @Test
    public void readExcelTests() throws IOException {
        String dosyaYolu="src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);
        // olusturdugumuz workbook, online olarak excel dosyasina erismez
        // 18.satirda fileInputStream kullanarak excel'deki bilgileri aldik
        // 20.satirda fis'in aldigi bilgileri kullanarak kodlarimizin icinde
        // fiziki excl dosyasinin bir kopyasini olusturmus olduk.
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3); // index
        Cell cell = row.getCell(3); // index
        System.out.println(cell); // Cezayir

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(0).getCell(1)); // Başkent (İngilizce)
        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData=sheet.getRow(0).getCell(1).toString(); // istenen data cell olduğu için String'e atayabilmemiz için toString yapmalıyız.
        System.out.println(istenenData); //Başkent (İngilizce)

        // - 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        String expectedData="Kabil";
        String actualData=sheet.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedData,actualData);

        // - Satir sayisini bulalim
        System.out.println(sheet.getLastRowNum()+1); //method 190 yani son satırın indexini verir, satır sayısı için +1 dedik
        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows()); // index değil kullanılan satır sayısını yazdırır.
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        String isim;
        String baskent;
        Map<String,String> ulkelerMap=new TreeMap<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            isim=sheet.getRow(i).getCell(0).toString();
            baskent=sheet.getRow(i).getCell(1).toString();
            ulkelerMap.put(isim,baskent);

        }

        // ulkeler excel'inde Canada olup olmadığını test edin
        Assert.assertTrue(ulkelerMap.containsKey("Canada"));

        // ulkeler excel'inde Cuba 'nın baskentinin Havana olduğunu test edin.
        String expectedBaskent="Havana";
        String actualBaskent=ulkelerMap.get("Cuba");

        Assert.assertEquals(expectedBaskent,actualBaskent);

    }
}
