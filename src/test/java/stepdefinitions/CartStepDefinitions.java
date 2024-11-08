package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Customer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import tasks.login.*;
import ui.CartPage;
import ui.PaymentPage;
import ui.ProductsPage;

import java.util.List;

public class CartStepDefinitions {

    private Customer customer;

    @When("{actor} adds a product to the cart")
    public void theUserAddsAProductToTheCart(Actor actor) {
        actor.attemptsTo( new AddProductToCartTask() );
    }

    @Then("the product should appear in the cart with the quantity icon updated")
    public void theProductShouldAppearInTheCartWithTheQuantityIconUpdated() {
        Ensure.that(ProductsPage.cartBadge).isDisplayed();
    }

    @Given("{actor} has added at least one product to the cart")
    public void theUserHasAddedAtLeastOneProductToTheCart(Actor actor) {
        actor.attemptsTo( new AddProductToCartTask() );
    }

    @When("{actor} clicks on the cart icon")
    public void theUserClicksOnTheCartIcon(Actor actor) {
        actor.attemptsTo( new GoToCartTask() );
    }

    @Then("{actor} should see the added products with their prices and quantities")
    public void theUserShouldSeeTheAddedProductsWithTheirPricesAndQuantities(Actor actor) {
        Ensure.that(Text.of(CartPage.productName)).isEqualTo(actor.recall("Product name"));
        Ensure.that(Text.of(CartPage.productPrice)).isEqualTo(actor.recall("Product price"));
    }

    @When("{actor} clicks the Checkout button")
    public void theUserClicksTheButton(Actor actor) {
        actor.attemptsTo( new GoToCheckoutTask() );
    }

    @Then("{actor} is redirected to the checkout information page")
    public void theUserIsRedirectedToTheCheckoutInformationPage(Actor actor) {
        Ensure.that(Text.of(PaymentPage.title)).isEqualTo("Checkout: Your Information");
    }

    @When("{actor} enters their personal data")
    public void theUserEntersTheirAnd(Actor actor, DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for(List<String> val: rows)
            this.customer = new Customer(val.get(0), val.get(1), val.get(2));

        actor.attemptsTo( new CheckOutTask(this.customer) );
    }

    @Then("{actor} is redirected to the order summary page")
    public void theUserIsRedirectedToTheOrderSummaryPage(Actor actor) {
        Ensure.that(Text.of(PaymentPage.title)).isEqualTo("Checkout: Overview");
    }

    @Then("{actor} sees the order confirmation page with a success message")
    public void theUserSeesTheOrderConfirmationPageWithASuccessMessage(Actor actor) {
        Ensure.that(Text.of(PaymentPage.paymentMessage)).isEqualTo("Thank you for your order!");
    }

    @And("{actor} clicks the finish button")
    public void clicksTheFinishButton(Actor actor) {
        actor.attemptsTo( new DoPaymentTask() );
    }
}
