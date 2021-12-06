package client.views.myAccountView;

import client.model.personal.Personal;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObjects.user.User;

public class MyAccountViewModel {
    private StringProperty firstName, lastName, email, phone, license, street, number, city, country, zip, DOB;

    private User identity = Personal.getPersonal().getIdentity();

    public MyAccountViewModel() {
        firstName = new SimpleStringProperty(identity.getfName());
        lastName = new SimpleStringProperty(identity.getlName());
        email = new SimpleStringProperty(identity.getEmail().getEmail());
        phone = new SimpleStringProperty(identity.getPhoneNo() +"");
       // license = new SimpleStringProperty();
       // street = new SimpleStringProperty();
       // number = new SimpleStringProperty();
       // city = new SimpleStringProperty();
       // country = new SimpleStringProperty();
       // zip = new SimpleStringProperty();
       // DOB = new SimpleStringProperty();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty phoneProperty() {
        return phone;
    }
}
