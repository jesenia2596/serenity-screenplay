package meeting;

import org.openqa.selenium.By;

public class MeetingForm {
    public static By BUTTON_NEW_MEET = By.xpath("//*[@id=\"GridDiv\"]/div[2]/div[2]/div/div/div[1]");
    public static By INPUT_NAME = By.name("MeetingName");
    public static By INPUT_START_DATE = By.name("StartDate");
    public static By INPUT_END_DATE = By.name("EndDate");

    public static By SELECT_MEETING_TYPE = By.xpath("/html/body/div[2]/div[1]/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[2]/div[1]/a/span[2]/b");
    public static By SELECT_MEETING_SEARCH = By.xpath("/html/body/div[7]/div/input");
    public static By SELECT_MEETING_RESULT = By.className("select2-result-label");


    public static By SELECT_UNIT = By.xpath("/html/body/div[2]/div[1]/section/div[2]/div[2]/div[1]/div[2]/form/div/div/div/div/div[7]/div[1]/a/span[2]/b");
    public static By SELECT_UNIT_SEARCH = By.xpath("/html/body/div[8]/div/input");
    public static By SELECT_UNIT_RESULT = By.className("select2-result-label");

    public static By BUTTON_SAVE = By.className("fa-floppy-o");
}
