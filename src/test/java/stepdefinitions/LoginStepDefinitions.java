package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import tasks.login.DoLoginTask;
import tasks.login.LoginTask;
import ui.LoginPage;

import java.util.List;

public class LoginStepDefinitions {
    private User user;

    @Given("{actor} is on the login page")
    public void the_user_is_on_the_login_page(Actor actor) {
        // Navigate to the login page or verify that the user is currently on it
        actor.attemptsTo(Open.browserOn().the(LoginPage.class));
    }

    @When("{actor} enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password(Actor actor, DataTable dataTable) {
        // Enter a valid username and password in the login fields
        List<List<String>> rows = dataTable.asLists(String.class);
        for(List<String> val: rows)
            user = new User(val.get(0), val.get(1));

        actor.attemptsTo( new LoginTask(user) );
    }

    @When("{actor} clicks the Login button")
    public void clicks_the_button(Actor actor) {
        // Simulate a click on the Login button to submit the credentials
        actor.attemptsTo( new DoLoginTask() );
    }

    @Then("{actor} should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page(Actor actor) {
        // Verify that the user has been redirected to the dashboard page
        Ensure.that(
                Target.the("Title")
                .locatedBy("//span[text()='Products']")
        )
        .textContent()
        .isEqualTo("Product");
    }

    @Then("the products should be visible")
    public void the_products_should_be_visible() {
        // Verify that products are displayed on the dashboard page
        Ensure.that(
                Target.the("Product list")
                .locatedBy("//div[@class='inventory_list']/div[@class='inventory_item']")
        ).isDisplayed();
    }

    @When("{actor} enters an invalid username or password")
    public void the_user_enters_an_invalid_username_or_password(Actor actor, DataTable dataTable) {
        // Enter an invalid username or password in the login fields
        List<List<String>> rows = dataTable.asLists(String.class);
        for(List<String> val: rows)
            user = new User(val.get(0), val.get(1));

        actor.attemptsTo( new LoginTask(user) );
    }

    @Then("an error message should be displayed saying Invalid username or password")
    public void an_error_message_should_be_displayed_saying() {
        // Check that an error message is displayed indicating incorrect credentials
        Ensure.that(
                Target.the("error message")
                .locatedBy("//h3[@data-test='error']")
        )
        .textContent()
        .containsIgnoringCase("Epic sadface: Username and password do not match any user in this service");
    }

    @Then("{actor} should remain on the login page")
    public void the_user_should_remain_on_the_login_page(Actor actor) {
        // Verify that the user has not been redirected from the login page
        Ensure.thatTheCurrentPage().pageSource().isEqualTo("/");
    }
}