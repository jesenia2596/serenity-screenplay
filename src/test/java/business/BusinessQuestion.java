package business;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

public class BusinessQuestion {

    public static Question<Boolean> existItemCreated( String name ) {
        return actor -> BrowseTheWeb.as(actor).find(By.linkText(name)).isPresent();
    }

}
