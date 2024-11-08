package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    public static final Target checkoutButton = Target.the("addCart")
            .locatedBy("//button[@id='checkout']");
    public static final Target productName = Target.the("product name")
            .locatedBy("//div[@class='inventory_item_name']");
    public static final Target productPrice = Target.the("product price")
            .locatedBy("//div[@class='inventory_item_price']");
}
