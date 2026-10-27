package tests;

import base.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InputsPage;

public class InputsTest extends TestBase {

    @Test
    public void testInputNumbers() {
        InputsPage page = new InputsPage(driver, wait);
        page.open();

        page.sendKeys("5");
        Assert.assertEquals(page.getValue(), "5", "Значение должно быть '5'");

        // Очищаем
        page.clear();

        page.sendKeys(String.valueOf(Keys.ARROW_UP));
        Assert.assertEquals(page.getValue(), "1", "После ARROW_UP должно быть '1'");

        page.sendKeys(String.valueOf(Keys.ARROW_DOWN));
        Assert.assertEquals(page.getValue(), "0", "После ARROW_DOWN должно быть '0'");
    }

    @Test
    public void testInputNonNumeric() {
        InputsPage page = new InputsPage(driver, wait);
        page.open();

        page.sendKeys("abc");
        String value = page.getValue();
        Assert.assertTrue(value.isEmpty() || value.equals("0"),
                "Поле не должно принимать нецифровые символы");
    }
}