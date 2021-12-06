package server.model.user.admin;

import server.database.user.admin.AdminUserModelDatabase;
import server.database.user.admin.AdminUserModelDatabaseImpl;
import shared.transferObjects.user.Admin;

import java.util.ArrayList;

public class AdminModelServerImpl implements AdminModelServer
{
  private AdminUserModelDatabase adminUserModelDatabase;

  public AdminModelServerImpl()
  {
    this.adminUserModelDatabase = new AdminUserModelDatabaseImpl();
  }

  @Override public ArrayList<Admin> getAllAdmins()
  {
    return adminUserModelDatabase.getAllAdmins();
  }

  @Override public Admin getAdminById(int empId)
  {
    return adminUserModelDatabase.getAdminById(empId);
  }

  @Override public void createAdmin(Admin admin)
  {
   adminUserModelDatabase.createAdmin(admin);
  }

  @Override public void updateAdmin(Admin admin)
  {
    adminUserModelDatabase.updateAdmin(admin);
  }

  @Override public void deleteAdmin(Admin admin)
  {
    adminUserModelDatabase.deleteAdmin(admin);
  }
}
