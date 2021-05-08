package login;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import homepage.HomePage;


public class LoginQuestion {

    public static Question<Boolean> ishomeDisplayed() {
        return actor -> BrowseTheWeb.as(actor).find(HomePage.INPUT_SEARCH).isPresent();
    }

}