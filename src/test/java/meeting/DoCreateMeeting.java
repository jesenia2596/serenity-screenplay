package meeting;

import business.BusinessForm;
import business.DoCreateBusiness;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoCreateMeeting implements Task {

    private final MeetModel meetModel;

    public DoCreateMeeting( MeetModel meetModel ) {
        this.meetModel = meetModel;
    }

    public static Performable withInput(MeetModel meetModel) {
        return instrumented( DoCreateMeeting.class, meetModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue( this.meetModel.getName()).into(MeetingForm.INPUT_NAME),

                Click.on(MeetingForm.SELECT_MEETING_TYPE),
                Enter.theValue(this.meetModel.getType()).into(MeetingForm.SELECT_MEETING_SEARCH),
                Click.on( MeetingForm.SELECT_MEETING_RESULT ),

                Click.on(MeetingForm.INPUT_START_DATE),
                Clear.field(MeetingForm.INPUT_START_DATE),
                Enter.theValue(this.meetModel.getStartDate()).into(MeetingForm.INPUT_START_DATE),


                Click.on(MeetingForm.INPUT_END_DATE),
                Clear.field(MeetingForm.INPUT_END_DATE),
                Enter.theValue(this.meetModel.getStartDate()).into(MeetingForm.INPUT_END_DATE),

                Click.on(MeetingForm.SELECT_UNIT),
                Enter.theValue(this.meetModel.getUnit()).into(MeetingForm.SELECT_UNIT_SEARCH),
                Click.on( MeetingForm.SELECT_UNIT_RESULT ),

                Click.on( MeetingForm.BUTTON_SAVE )
        );
    }
}
