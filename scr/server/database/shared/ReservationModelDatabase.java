package server.database.shared;

import shared.transferObjects.Reservation;

import java.util.ArrayList;

public interface ReservationModelDatabase
{
  ArrayList<Reservation> getAllReservations();
  Reservation getReservationByReservationID(String reservationId);
  ArrayList<Reservation> getAllCustomerReservations(String customerId);
  void deleteReservation(String reservationId);
  void updateReservation(String reservationId);
  void createReservation();
}
