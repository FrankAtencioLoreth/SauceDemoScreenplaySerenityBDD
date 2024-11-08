package tasks.login;

import models.Customer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.PaymentPage;

public class CheckOutTask implements Task {

    private final Customer customer;

    public CheckOutTask(Customer customer) {
        this.customer = customer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.customer.getFirstname()).into(PaymentPage.firstNameInput),
                Enter.theValue(this.customer.getLastname()).into(PaymentPage.lastNameInput),
                Enter.theValue(this.customer.getLastname()).into(PaymentPage.zipCodeInput)
        );
        actor.attemptsTo(Click.on(PaymentPage.continueButton));
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }
}
