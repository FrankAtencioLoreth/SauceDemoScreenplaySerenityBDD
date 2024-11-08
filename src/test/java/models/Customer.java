package models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {

    private String firstname;
    private String lastname;
    private String zipcode;

    public Customer(String firstname, String lastname, String zipcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.zipcode = zipcode;
    }
}
