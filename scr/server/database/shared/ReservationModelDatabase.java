package server.database.shared;

import shared.transferObjects.Reservation;

import java.util.ArrayList;

public interface ReservationModelDatabase
{
  ArrayList<Reservation> getAllReservations();
  Reservation getReservationByReservationID(String reservationId);
  ArrayList<Reservation> getAllCustomerReservations(String customerId);
  void deleteReservation(Reservation reservation);
  void updateReservation(Reservation reservation);
  void createReservation(Reservation reservation);
}
