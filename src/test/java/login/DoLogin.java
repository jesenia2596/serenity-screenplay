package login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class DoLogin implements Task {

    private final String password;
    private final String username;

    public DoLogin( String username, String password ) {
        this.password = password;
        this.username = username;
    }

    public static Performable withCredentials( String username, String password) {
        return instrumented( DoLogin.class, username, password);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginForm.INPUT_USER),
                Enter.theValue(password).into(LoginForm.INPUT_PASSWORD),
                Click.on(LoginForm.BUTTON)
        );
    }
}
