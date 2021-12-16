package server.DataAccess;


import shared.transferObjects.Address;
import shared.transferObjects.Car;
import shared.transferObjects.PlateNo;
import shared.transferObjects.Reservation;
import shared.transferObjects.user.*;

import java.rmi.server.RemoteServer;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

public class TestDataBase {
    public static void main(String[] args) throws SQLException {

        {

            Date date1 = new Date(95, 12, 18);
            Date date2 = new Date(99, 1, 15);
            Date date3 = new Date(80, 8, 22);
            Date date4 = new Date(93, 10, 01);

            Address address1 = new Address("Denmark", "Horsens", "teknisk", "1", 8700);
            Address address2 = new Address("Denmark", "Aarhus", "oddervej", "1", 8000);
            Address address3 = new Address("Denmark", "København", "teknisk", "1",
                    2100);
            Address address4 = new Address("Denmark", "Juelsmi", "teknisk", "1",
                    7130);

            Email email1 = new Email("simus@gmail.com");
            Email email2 = new Email("vlad@gmail.com");
            Email email3 = new Email("alfonso@gmail.com");
            Email email4 = new Email("Christopher@gmail.com");

            Password password1 = new Password("Vlad1234");
            Password password2 = new Password("Simus1234");
            Password password3 = new Password("Christopher1234");
            Password password4 = new Password("Alfonso1234");

            PhoneNo phoneNo1 = new PhoneNo("11111111");
            PhoneNo phoneNo2 = new PhoneNo("22222222");
            PhoneNo phoneNo3 = new PhoneNo("33333333");
            PhoneNo phoneNo4 = new PhoneNo("44444444");

            Ssn ssn1 = new Ssn("1111111111");
            Ssn ssn2 = new Ssn("2222222222");
            Ssn ssn3 = new Ssn("3333333333");
            Ssn ssn4 = new Ssn("4444444444");

            DriverLicense driverLicense = new DriverLicense("00000000");

            Admin simus = new Admin("Simus", "something", address1, phoneNo1, password1,
                    email1, date1, ssn1);

            FrontDesk chico = new FrontDesk("Christopher", "Gadgaard", address2, phoneNo2,
                    password2, email4, date2, ssn3,address1);

            Admin christopher = new Admin("Christopher", "Gadgaard", address2, phoneNo2,
                    password2, email2, date2, ssn2);

            Customer vlad = new Customer("Vlad", "Lazar", address3, phoneNo3, password4,
                    email3, date3, driverLicense);

            FrontDesk alfonso = new FrontDesk("Alfonso", "Ridao", address2, phoneNo2,
                    password2, email2, date4, ssn1, address1);


    /*       UsersData usersData = new DataBaseUserHandler();
            usersData.storeUser(simus);
            usersData.storeUser(chico);
            usersData.storeUser(vlad);

            PlateNo plateNo = new PlateNo("aa12345");

            Car car = new Car("bmw","M3",2020,2000,"van",500,1000,"Horsens",plateNo);
            CarsData carsData = new DataBaseCarsHandler();
            carsData.storeCar(car);*/

           Reservation reservation = new Reservation(new Timestamp(1999,1,1,12,12,12,12),new Timestamp(1999,1,2,12,12,12,12),3000,3001,3002,1000);
            ReserveData reserveData = new DataBaseReservationHandler();
            reserveData.storeReservation(reservation);


/*
            UserModelDatabase userModelDatabase = new UserModelDatabaseImpl();

   /* userModelDatabase.createUser(simus);
    System.out.println("Simus created");
    userModelDatabase.createUser(christopher);
    System.out.println("Christopher created");
    userModelDatabase.createUser(vlad);
    System.out.println("Vlad created");
    userModelDatabase.createUser(alfonso);
    System.out.println("Alfonso created");

            System.out.println(userModelDatabase.getUsersByType(LoginType.ADMIN));
            System.out.println(userModelDatabase.getUsersByType(LoginType.CUSTOMER));
            System.out.println(userModelDatabase.getUsersByType(LoginType.FRONT_DESK));

            System.out.println(userModelDatabase.getUserById(3002,LoginType.ADMIN));
            System.out.println(userModelDatabase.getUserById(4001,LoginType.CUSTOMER));
            System.out.println(userModelDatabase.getUserById(5001,LoginType.FRONT_DESK));

            LoginModelDatabase loginModelDatabase = new LoginModelDatabaseImp();



            System.out.println(loginModelDatabase.login(email1,password1));
*//*


             UsersData usersData = new DataBaseUserHandler();
             usersData.deleteUser(3005);
       //      usersData.storeUser(christopher);
         //    usersData.storeUser(alfonso);
          //   usersData.storeUser(chico);
           //  usersData.storeUser(vlad);
            // usersData.storeUser(simus);

            usersData.deleteUser(3002);

*/
/*

          // usersData.deleteUser(3001);
           // for (User user: usersData.getUserList())
               // System.out.println(3000);
          //  dataBaseUserHandler.updateUser(3000, vlad);
            //System.out.println(getUsers.getUserById(3001));
          //  System.out.println(getUsers.isAvailable(new Email("vld@gmail.com")));
         //   System.out.println(getUsers.login(new Email("vlad@gmail.com"), new Password("Simus1234")));
           // System.out.println(getUsers.login(new Email("alfonso@gmail.com"), new Password("Christopher1234")));
               // getUsers.deleteUser(3002);
         //   getUsers.updateUser(new Email("simus@gmail.com"), 3003);
       //     DeleteUser deleteUser = new DeleteUser();
        //    deleteUser.init(4002);
       //     User user = new User();
         //   System.out.println(user.exist(1005));

/*
            LocalDate date = LocalDate.now();
            LocalDate otherDate = date.plusDays(5);
            Timestamp start = Timestamp.valueOf(date.atStartOfDay());
            Timestamp end = Timestamp.valueOf(otherDate.atStartOfDay());
            Reservation reservation = new Reservation(start, end, 23, 54, 3004, 1000);
            ReserveData reserveData = new DataBaseReservationHandler();
            reserveData.storeReservation(reservation);
*//*




            ReserveData reserveData = new DataBaseReservationHandler();
            for (Reservation reservation : reserveData.getListReservations()) {
                System.out.println(reservation);
            }



            */
/*
            Car car = new Car("Tesla", "S", 2001,1999, "Sedan", 2100, 1222, "Aarhus", new PlateNo("CD44444"));
            CarsData carsData = new DataBaseCarsHandler();
            carsData.storeCar(car);


             *//*


*/

        }

    }
}
