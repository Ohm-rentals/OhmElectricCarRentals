package server.model.user.admin;

import shared.transferObjects.user.Admin;

import java.util.ArrayList;

public interface AdminModelServer
{
  ArrayList<Admin> getAllAdmins();
  Admin getAdminById(int empId);
  void createAdmin(Admin admin);
  void updateAdmin(Admin admin);
  void deleteAdmin(Admin admin);
}
