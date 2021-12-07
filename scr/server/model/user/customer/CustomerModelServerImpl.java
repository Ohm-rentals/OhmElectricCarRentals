package server.model.user.customer;

import server.database.user.customer.CustomerUserModelDatabase;
import server.database.user.customer.CustomerUserModelDatabaseImpl;
import shared.transferObjects.user.Customer;

import java.util.ArrayList;

public class CustomerModelServerImpl implements CustomerModelServer
{
  private CustomerUserModelDatabase customerUserModelDatabase;

  public CustomerModelServerImpl()
  {
    this.customerUserModelDatabase = new CustomerUserModelDatabaseImpl();
  }

  @Override public ArrayList<Customer> getAllCustomers()
  {
    return customerUserModelDatabase.getAllCustomers();
  }

  @Override public Customer getCustomerById(int customerId)
  {
    return customerUserModelDatabase.getCustomerById(customerId);
  }

  @Override public void createCustomer(Customer customer)
  {
    customerUserModelDatabase.createCustomer(customer);
  }

  @Override public void updateCustomer(Customer customer)
  {
    customerUserModelDatabase.updateCustomer(customer);
  }

  @Override public void deleteCustomer(Customer customer)
  {
    customerUserModelDatabase.deleteCustomer(customer);
  }
}
