package starter.login;

import models.CredentialsForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

public class Credentials implements Task {

    CredentialsForm DataFill;

    public Credentials(List<String> dataToFillLogin) {this.DataFill = new CredentialsForm(dataToFillLogin);

    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(DataFill.getUserName()).into(LoginForm.USER_FIELD),
                Enter.theValue(DataFill.getPassword()).into(LoginForm.PASSWORD_FIELD),
                Click.on(LoginForm.LOGIN_BUTTON));


    }
    public static Credentials withTheData(List<String>form) {return new Credentials(form);}
}