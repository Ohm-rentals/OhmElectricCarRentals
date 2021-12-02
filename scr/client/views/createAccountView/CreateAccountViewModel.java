package client.views.createAccountView;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObjects.user.User;

public class CreateAccountViewModel {
    private StringProperty firstName, lastName, email, phone, license, street, number, city, country, zip;

    public CreateAccountViewModel() {
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        license = new SimpleStringProperty();
        street = new SimpleStringProperty();
        number = new SimpleStringProperty();
        city = new SimpleStringProperty();
        country = new SimpleStringProperty();
        zip = new SimpleStringProperty();
    }

    public void createAccount() {

        System.out.println(firstName.getValue());
        firstName.set("JoderTios");
        //Create User
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }



}
