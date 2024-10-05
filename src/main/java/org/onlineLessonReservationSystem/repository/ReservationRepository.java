package org.onlineLessonReservationSystem.repository;

import org.onlineLessonReservationSystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Ekstra sorgular eklenebilir
}