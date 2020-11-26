package starter.stepdefinitions;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static com.google.common.base.Predicates.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import starter.login.Credentials;
import starter.navigation.NavigateTo;
import starter.verifyaccount.AccountData;

import java.util.List;

public class LoginStepDefinitions {

    String name;

    @Before
    public void setTheStage() { OnStage.setTheStage(new OnlineCast());}

    @Given("the (.*) is on page WMU")
    public void the_User_is_on_page_WMU(String user) {
        this.name = user;
        theActorCalled(user).attemptsTo(
                NavigateTo.WmuPage()
        );
    }

    @When("enters the credentials")
    public void enters_the_credentials(List<String> form) {
        theActorInTheSpotlight().attemptsTo(Credentials.withTheData(form));
    }

    @Then("the user is successfully logged in")
    public void the_user_is_successfully_logged_in(){
        theActorInTheSpotlight().should(


                seeThat(  "The Profile name", AccountData.CurrentProfileName(),equalTo( "System Administrator"))
        );
    }

}


