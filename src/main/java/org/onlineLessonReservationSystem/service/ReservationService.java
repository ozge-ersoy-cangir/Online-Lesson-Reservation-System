package org.onlineLessonReservationSystem.service;

import org.onlineLessonReservationSystem.model.Reservation;
import org.onlineLessonReservationSystem.model.User;
import org.onlineLessonReservationSystem.model.Lesson;
import org.onlineLessonReservationSystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Tüm rezervasyonları getir
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    // ID ile rezervasyonu getir
    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Yeni rezervasyon oluştur
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Rezervasyonu güncelle
    public Optional<Reservation> updateReservation(Long id, Reservation reservationDetails) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setUser(reservationDetails.getUser());
            reservation.setLesson(reservationDetails.getLesson());
            reservation.setReservationDate(reservationDetails.getReservationDate());
            return reservationRepository.save(reservation);
        });
    }

    // Rezervasyonu sil
    public boolean deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Kullanıcıyı getir
    public User getUser(Long id) {
        // Kullanıcıyı bulma işlemi buraya eklenmeli
        return null; // Dummy dönüş
    }

    // Dersi getir
    public Lesson getLesson(Long id) {
        // Dersi bulma işlemi buraya eklenmeli
        return null; // Dummy dönüş
    }

    // Rezervasyon tarihını getir
    public LocalDateTime getReservationDate(Long id) {
        // Rezervasyon tarihını alma işlemi buraya eklenmeli
        return null; // Dummy dönüş
    }

    // Rezervasyon tarihını ayarla
    public void setReservationDate(Long id, LocalDateTime date) {
        // Rezervasyon tarihını ayarlama işlemi buraya eklenmeli
    }

    public Reservation findById(long l) {
        return null;
    }

    public List<Reservation> findAll() {
        return null;
    }
}