package day07_assertions_checkBox;

import org.junit.Test;
import utilities.TestBase;

public class C05_TestBaselikClass extends TestBase {


    @Test
    public void test01(){
        driver.get("https://amazon.com");
        bekle(2);
    }

}
