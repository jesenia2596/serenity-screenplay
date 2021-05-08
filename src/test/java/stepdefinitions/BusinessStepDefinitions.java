package stepdefinitions;

import business.BusinessQuestion;
import business.DoCreateBusiness;
import business.DoOpenModalBusiness;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.DoLogin;
import login.LoginQuestion;
import navegation.Navegation;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class BusinessStepDefinitions {
    private String actor;
    private String name;
    private String parentUnit;

    @Before
    public void seeTheStage(){
        this.actor="user";
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("user needs to create business unit")
    public void user_needs_to_create_business_unit() {
        theActorCalled( actor ).attemptsTo(Navegation.theLoginPage());
        theActorCalled( this.actor ).attemptsTo(DoLogin.withCredentials("admin", "serenity"));
        theActorInTheSpotlight().should(
                seeThat("The home page", LoginQuestion.ishomeDisplayed(), equalTo(true))
        );
        theActorCalled( actor ).attemptsTo(Navegation.theBusinessPage());
    }

    @When("select button create business unit")
    public void select_button_create_business_unit() {
        theActorCalled( this.actor ).attemptsTo(DoOpenModalBusiness.openModal());
    }

    @When("Enter name {string}")
    public void enter_name(String name) {
        this.name = name;
    }

    @When("select parent unit {string}")
    public void select_parent_unit(String parentUnit) {
        this.parentUnit = parentUnit;
    }

    @Then("after saving you should see the record created")
    public void after_saving_you_should_see_the_record_created() {
        theActorCalled( this.actor ).attemptsTo(DoCreateBusiness.withCredentials(this.name, this.parentUnit));
        theActorInTheSpotlight().should(
                seeThat("The the created record", BusinessQuestion.existItemCreated(this.name), equalTo(true))
        );
    }

}
