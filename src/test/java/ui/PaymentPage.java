package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class PaymentPage extends PageObject {

    public static final Target  firstNameInput = Target.the("firstname")
            .locatedBy("//input[@id='first-name']");
    public static final Target  lastNameInput = Target.the("lastname")
            .locatedBy("//input[@id='last-name']");
    public static final Target  zipCodeInput = Target.the("zip code")
            .locatedBy("//input[@id='postal-code']");
    public static final Target  continueButton = Target.the("continue")
            .locatedBy("//input[@id='continue']");
    public static final Target  finishButton = Target.the("finish")
            .locatedBy("//button[@id='finish']");
    public static final Target  paymentMessage = Target.the("payment message")
            .locatedBy("//h2[@class='complete-header']");
    public static final Target title = Target.the("Title")
            .locatedBy("//*[@id=\"header_container\"]/div[2]/span");

}
