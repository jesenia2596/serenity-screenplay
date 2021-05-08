package business;

import org.openqa.selenium.By;

public class BusinessForm {
    public static By BUTTON_NEW_UNIT = By.xpath("//*[@id=\"GridDiv\"]/div[2]/div[2]/div/div/div[1]/div/span");
    public static By INPUT_NAME = By.id("StartSharp_Organization_BusinessUnitDialog7_Name");
    public static By INPUT_SELECT_PARENT_UNIT = By.id("s2id_StartSharp_Organization_BusinessUnitDialog7_ParentUnitId");
    public static By INPUT_SELECT_SEARCH = By.id("s2id_autogen1_search");
    public static By INPUT_SELECT_RESULT = By.className("select2-result-label");
    public static By BUTTON_SAVE = By.className("fa-floppy-o");

}
