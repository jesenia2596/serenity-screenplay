package stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.DoLogin;
import login.LoginQuestion;
import meeting.DoCreateMeeting;
import meeting.DoOpenModalMeeting;
import meeting.MeetModel;
import meeting.MeetingQuestion;
import navegation.Navegation;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateMettingStepDefinitions {

    private String actor;
    private MeetModel meetModel = new MeetModel();


    @Before
    public void seeTheStage(){
        this.actor="user";
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("user needs to create new meeting")
    public void user_needs_to_create_new_meeting() {
        theActorCalled( actor ).attemptsTo(Navegation.theLoginPage());
        theActorCalled( this.actor ).attemptsTo(DoLogin.withCredentials("admin", "serenity"));
        theActorInTheSpotlight().should(
                seeThat("The home page", LoginQuestion.ishomeDisplayed(), equalTo(true))
        );
        theActorCalled( actor ).attemptsTo(Navegation.theMeetingPage());
    }

    @When("select button create meeting")
    public void select_button_create_meeting() {
        theActorCalled( this.actor ).attemptsTo(DoOpenModalMeeting.openModal());
    }

    @When("Enter meet name {string}")
    public void enter_meet_name(String name) {
        this.meetModel.setName( name );
    }

    @When("select meet type {string}")
    public void select_meet_type(String type) {
        this.meetModel.setType( type );
    }

    @When("Enter the start date {string}")
    public void enter_the_start_date(String starDate) { this.meetModel.setStartDate( starDate );  }

    @When("Enter the end date {string}")
    public void enter_the_end_date(String endAte) { this.meetModel.setEndDate( endAte );    }

    @When("Select unit {string}")
    public void select_unit(String unit) { this.meetModel.setUnit(unit);}


    @Then("after saving you should see the new meeting record created")
    public void after_saving_you_should_see_the_new_meeting_record_created() {
        theActorCalled( this.actor ).attemptsTo(DoCreateMeeting.withInput( this.meetModel ));
        theActorInTheSpotlight().should(
                seeThat("The the created record", MeetingQuestion.existItemCreated(this.meetModel.getName()), equalTo(true))
        );
    }



}
