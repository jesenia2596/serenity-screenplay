package business;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoCreateBusiness implements Task {

    private final String name;
    private final String parentUnit;

    public DoCreateBusiness( String name, String parentUnit ) {
        this.parentUnit = parentUnit;
        this.name = name;
    }

    public static Performable withCredentials(String name, String parentUnit) {
        return instrumented( DoCreateBusiness.class, name, parentUnit);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).into(BusinessForm.INPUT_NAME),

                /**Click.on(BusinessForm.INPUT_SELECT_PARENT_UNIT),
                Enter.theValue(parentUnit).into(BusinessForm.INPUT_SELECT_SEARCH),
                Click.on(BusinessForm.INPUT_SELECT_RESULT),*/

                Click.on(BusinessForm.BUTTON_SAVE)
        );
    }
}
