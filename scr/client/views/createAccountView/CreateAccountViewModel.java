package client.views.createAccountView;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;


public class CreateAccountViewModel {
    private StringProperty firstName, lastName, email, phone, license, addressStreet, addressNumber, addressCity, addressCountry, addressZip, DOB;
    private Password password;


    public CreateAccountViewModel() {
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        license = new SimpleStringProperty();
        DOB = new SimpleStringProperty();
        addressStreet = new SimpleStringProperty();
        addressNumber = new SimpleStringProperty();
        addressCity = new SimpleStringProperty();
        addressCountry = new SimpleStringProperty();
        addressZip = new SimpleStringProperty();
    }

    public void createAccount(Password password) {

        System.out.println(firstName.getValue());
        System.out.println(DOB.getValue());
        firstName.set("JoderTios");
        //Create User
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty DOBProperty() {
        return DOB;
    }
}
