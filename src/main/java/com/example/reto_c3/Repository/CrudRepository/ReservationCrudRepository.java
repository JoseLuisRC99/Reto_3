package com.example.reto_c3.Repository.CrudRepository;

import com.example.reto_c3.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    //RETO_5
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();
    public List<Reservation> findAllByStatus(String status);
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

}
