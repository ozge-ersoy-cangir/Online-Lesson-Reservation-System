package org.onlineLessonReservationSystem.controller;

import org.onlineLessonReservationSystem.model.Reservation;
import org.onlineLessonReservationSystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    // Dependency Injection ile ReservationService sınıfını kullan
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Tüm rezervasyonları getir
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAllReservations();
    }

    // ID ile rezervasyon getir
    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.findReservationById(id);
    }

    // Yeni rezervasyon oluştur
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    // Mevcut rezervasyonu güncelle
    @PutMapping("/{id}")
    public Optional<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        return reservationService.updateReservation(id, reservationDetails);
    }

    // Belirli bir rezervasyonu sil
    @DeleteMapping("/{id}")
    public boolean deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservation(id);
    }
}