package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends TestBase {

    @Test
    public void testDropdown() {
        DropdownPage page = new DropdownPage(driver, wait);
        page.open();

        Assert.assertEquals(page.getOptionsCount(), 3, "В дропдауне должно быть 3 опции");

        page.selectByIndex(1);
        Assert.assertEquals(page.getSelectedOption(), "Option 1",
                "Должен быть выбран 'Option 1'");

        page.selectByIndex(2);
        Assert.assertEquals(page.getSelectedOption(), "Option 2",
                "Должен быть выбран 'Option 2'");
    }
}