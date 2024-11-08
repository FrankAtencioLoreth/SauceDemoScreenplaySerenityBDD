package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ProductsPage extends PageObject {

    public static final Target productName = Target.the("product name").locatedBy("//div[@class='inventory_item_name ']").containingText("Sauce Labs Backpack");
    public static final Target productPrice = Target.the("product price").locatedBy("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    public static final Target addCart = Target.the("addCart").locatedBy("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static final Target cart = Target.the("cart").locatedBy("//div[@id='shopping_cart_container']");
    public static final Target cartBadge = Target.the("cart").locatedBy("//span[@class='shopping_cart_badge']");

}
