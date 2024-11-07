package tasks.login;

import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import ui.LoginPage;

public class LoginTask implements Task {

    private final User user;

    public LoginTask(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.user.getUsername()).into(LoginPage.usernameInput),
                Enter.theValue(this.user.getPassword()).into(LoginPage.passwordInput)
        );
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }
}
