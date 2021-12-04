package server.database.user.customer;

import shared.transferObjects.user.Customer;

import java.util.ArrayList;

public interface CustomerUserModelDatabase
{
  ArrayList<Customer> getAllCustomers();
  Customer getCustomerById(int customerId);
  void createCustomer(Customer customer);
  void updateCustomer(Customer customer);
  void deleteCustomer(Customer customer);
}
