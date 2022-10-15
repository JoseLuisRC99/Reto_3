package com.example.reto_c3.Controller;

import com.example.reto_c3.Custom.CountClient;
import com.example.reto_c3.Custom.StatusAmount;
import com.example.reto_c3.Model.Reservation;
import com.example.reto_c3.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
@RestController
@RequestMapping("/api/Reservation")
@Repository
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

    //RETO_5

    @GetMapping("/report-clients")
    public List<CountClient> getReservationReportClient(){
        return reservationService.getTopClient();
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTow}")
    public List<Reservation> getReservationReportDates(@PathVariable("dateOne") String dateOne,  @PathVariable("dateTow") String dateTow){
        return reservationService.getReservationPeriod( dateOne, dateTow);
    }

}
