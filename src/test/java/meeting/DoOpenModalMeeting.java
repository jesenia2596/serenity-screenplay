package meeting;

import business.BusinessForm;
import business.DoOpenModalBusiness;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoOpenModalMeeting implements Task {


    public DoOpenModalMeeting( ) {}

    public static Performable openModal() {
        return instrumented( DoOpenModalBusiness.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MeetingForm.BUTTON_NEW_MEET)
        );

    }
}
