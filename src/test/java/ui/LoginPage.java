package ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("/")
public class LoginPage extends PageObject {

    public static final Target usernameInput = Target.the("username input")
            .locatedBy("//input[@id='user-name']");
    public static final Target passwordInput = Target.the("password input")
            .locatedBy("//input[@id='password']");
    public static final Target loginButton = Target.the("login button")
            .locatedBy("//input[@id='login-button']");

}
