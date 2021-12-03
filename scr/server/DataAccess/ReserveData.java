package server.DataAccess;

import shared.transferObjects.Reservation;

import java.util.List;

public interface ReserveData {
    void storeReservation(Reservation reservation);
    void deleteReservation(String id);
    void updateReservation(String id, Reservation newReservation);
    List<Reservation> getListReservations();
}
