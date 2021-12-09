package client.views.createAccountView;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.converter.LocalDateStringConverter;
import shared.transferObjects.Address;
import shared.transferObjects.user.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Timer;
import java.util.function.DoubleBinaryOperator;


public class CreateAccountViewModel {
    private StringProperty firstName, lastName, email, phone, license, addressStreet, addressNumber, addressCity, addressCountry, DOB, errorText;
    private IntegerProperty addressZip;
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
        addressZip = new SimpleIntegerProperty();
        errorText = new SimpleStringProperty();
    }

    public void createAccount(Password password, LoginType kind) {
        System.out.println(phone.getValue() + "Phone number");
        User newUser = null;
        System.out.println("Starting to create");
        try {
        Address address = new Address(addressCountry.getValue(),
                                      addressCity.getValue(),
                                      addressStreet.getValue(),
                                      addressNumber.getValue(),
                                      addressZip.getValue());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DOB = LocalDate.parse("16/08/2000",formatter);

        switch (kind) {
            case CUSTOMER -> newUser = new Customer(firstName.getValue(),
                                        lastName.getValue(),
                                        address,
                                        new PhoneNo(phone.getValue()),
                                        password,
                                        new Email(email.getValue()),
                                        Date.valueOf(DOB), // Please lets change this dates
                                        new DriverLicense(license.getValue()));
            case FRONT_DESK -> newUser = new FrontDesk(firstName.getValue(),
                                         lastName.getName(),
                                         address,
                                         new PhoneNo(phone.getValue()),
                                         password, new Email(email.getValue()),
                                         Date.valueOf(DOB),
                                    null,
                             null);
            case ADMIN -> newUser = new Admin(firstName.getValue(),
                                        lastName.getName(),
                                        address,
                                        new PhoneNo(phone.getValue()),
                                        password, new Email(email.getValue()),
                                        Date.valueOf(DOB),
                                        null);
        }


        } catch (Exception e) {
            errorText.set(e.getLocalizedMessage());
        }
        errorText.set("");
    }

     StringProperty firstNameProperty() {return firstName;}

     StringProperty DOBProperty() {return DOB;}

     StringProperty errorTextProperty() {return errorText; }

     StringProperty lastNameProperty() {return lastName; }

     StringProperty emailProperty() {return email;}

     StringProperty phoneProperty() {return phone;}

     StringProperty licenseProperty() {return license; }

     StringProperty addressStreetProperty() {return addressStreet;}

     StringProperty addressNumberProperty() {return addressNumber;}

     StringProperty addressCityProperty() {return addressCity;}

     StringProperty getAddressCountryProperty() {return addressCountry;}

     IntegerProperty getAddressZipProperty() {return addressZip;}
}
