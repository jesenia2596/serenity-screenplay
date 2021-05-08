package navegation;

import business.Businessnavegation;
import meeting.MeetingNavigation;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import login.LoginNavegation;


public class Navegation {

    public static Performable theLoginPage() {
        return Task.where("{0} opens the login page",
                Open.browserOn().the(LoginNavegation.class)
        );
    }

    public static Performable theBusinessPage() {
        return Task.where("{0} opens the home page",
                Open.browserOn().the(Businessnavegation.class)
        );
    }

    public static Performable theMeetingPage() {
        return Task.where("{0} opens the home page",
                Open.browserOn().the(MeetingNavigation.class)
        );
    }
}

